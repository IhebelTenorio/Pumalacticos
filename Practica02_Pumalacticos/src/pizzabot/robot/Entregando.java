package pizzabot.robot;

/**
 * La clase donde el robot esta en un estadp donde finaliza la atenció, dando la entrega al cliente
 * aqui no puede realizar ciertas acciones, e implementa la interfaz RobotState
 */
public class Entregando implements RobotState {

    /**
     * Muestra un error diciendo que el robot esta ocupado
     * @param robot instancia del robot
     */
    @Override
    public void llamar(Robot robot) {
        System.out.println("ERROR: El robot está ocupado, por favor espere a que termine la entrega.");
    }

    /**
     * Muestra un error diiendo que no puede confirmar una orden en el estado actual
     * @param robot instancia del robot
     */
    @Override
    public void confirmarOrden(Robot robot) {
        System.out.println("ERROR: No se puede confirmar una orden ahora.");
    }

    /**
     * Muestra error ya que la orden ya fue preparada 
     * @param robot instancia del robot 
     */
    @Override
    public void cancelarOrden(Robot robot) {
        System.out.println("ERROR: La orden ya fue preparada y no se puede cancelar.");
    }

    /**
     * Muestra error diciendo que la orden ya esta lista
     * @param robot instancia del robot 
     */
    @Override
    public void preparar(Robot robot) {
        System.out.println("ERROR: La orden ya ha sido preparada.");
    }

    /**
     * Entrega la orden al cliente, genera el ticket y limpia la orden ya echay cambia al robot al estado de dormir
     * @param robot instancia del robot
     */
    @Override
    public void entregar(Robot robot) {
        System.out.println("\n ORDEN ENTREGADA ");
        System.out.println("Generando ticket");
        System.out.println("¡Gracias por su compra! Vuelva pronto.");
        
        // a mimir
        robot.limpiarOrden();
        robot.setEstado(robot.getEstadoDormido());
        System.out.println("\nAtom ha vuelto a su estado mimido zzzzzz...");
    }
}