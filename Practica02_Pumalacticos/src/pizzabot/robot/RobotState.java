package pizzabot.robot; 

/**
 * Interfaz que define el contrato para los estados del robot 
 */
public interface RobotState {

    /**
     * LLama al robot para que atienda al cliente
     * @param robot el robot que se le realizara la acción
     */
    void llamar(Robot robot);

    /**
     * Confirma la orden actual
     * @param robot el robot que se le realizara la acción
     */
    void confirmarOrden(Robot robot);

    /**
     * Accion que cancela la orden actual
     * @param robot el robot que se le realizara la acción
     */
    void cancelarOrden(Robot robot);

    /**
     * Acción que prepara la orden del cliente
     * @param robot el robot que se le realizara la acción
     */
    void preparar(Robot robot);

    /**
     * Acción que entrega la orden al cliente
     * @param robot el robot que se le realizara la acción
     */
    void entregar(Robot robot);
    
}
