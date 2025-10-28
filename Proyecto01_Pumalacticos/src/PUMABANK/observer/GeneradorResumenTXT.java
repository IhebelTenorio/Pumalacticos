package PUMABANK.observer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Observador Concreto: GeneradorResumenTXT.
 * Recolecta todos los eventos de una cuenta y los almacena en una lista.
 * Puede guardar esta lista en un archivo .txt cuando se le indique.
 *
 * @author Pumalacticos
 */
public class GeneradorResumenTXT implements ReceptorNotificacion {

    private List<String> logEventos;
    private DateTimeFormatter formatter;
    private String numeroCuenta; // Guardamos el N° de cuenta para el nombre de archivo

    public GeneradorResumenTXT(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.logEventos = new ArrayList<>();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("RESUMEN DE CUENTA: Inicializado para cuenta " + numeroCuenta);
    }

    /**
     * Método llamado por el Sujeto (Cuenta)
     * @param evento Descripción del evento.
     */
    @Override
    public void actualizar(String evento) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " | " + evento;
        this.logEventos.add(logEntry);
        
        // Opcional: imprimir a consola en tiempo real
        // System.out.println("[LOG-TXT] Evento registrado: " + logEntry);
    }

    /**
     * Guarda el log de eventos acumulados en un archivo .txt y limpia la lista.
     * Este método es llamado externamente (ej. por la App al final del mes).
     * @param mes El número del mes que se está cerrando.
     */
    public void guardarLogMensual(int mes) {
        if (logEventos.isEmpty()) {
            System.out.println("[LOG-TXT] No hay eventos para guardar en cuenta " + numeroCuenta + " para el mes " + mes + ".");
            return;
        }

        String filename = "log_cuenta_" + this.numeroCuenta + "_mes_" + mes + ".txt";
        
        // Usamos try-with-resources para asegurar que se cierre el archivo
        // El 'true' en FileWriter significa que AÑADIRÁ (append) al archivo si ya existe.
        try (FileWriter fw = new FileWriter(filename, true);
             PrintWriter out = new PrintWriter(fw)) {
            
            out.println("\n INICIO RESUMEN (MES " + mes + ") | CUENTA " + this.numeroCuenta + "    ");
            for (String evento : logEventos) {
                out.println(evento);
            }
            out.println("FIN RESUMEN (MES " + mes + ") | CUENTA " + this.numeroCuenta + "    ");

            System.out.println("[LOG-TXT] Resumen del mes " + mes + " guardado en: " + filename);
            
            // Limpiamos la lista para el próximo mes
            this.logEventos.clear();

        } catch (IOException e) {
            System.err.println("[LOG-TXT] ERROR: No se pudo escribir el archivo de log: " + e.getMessage());
        }
    }
}