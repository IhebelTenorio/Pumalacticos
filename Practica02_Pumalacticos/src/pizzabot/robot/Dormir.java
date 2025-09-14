package pizzabot.robot; 

/**
 * La clase Dormir que tiene el estado donde el robot esta inactivo y no hace nada hasta recibir la llamada de un cliente
 * lo cual se logra implementando la interfaz de RobotState
 */
public class Dormir implements RobotState {

    /**
     * Despierta al robot y cambia su estado a atender 
     * @param robot instancia del robot en estado dormir 
     */
    @Override
    public void llamar(Robot robot) {
        System.out.println("El robot se está despertando, calma...");
        robot.setEstado(robot.getEstadoAtendiendo());
    }

    /**
     * Checa la confirmación de la orden, en caso de que si muetsra un error ya que no puede recibir ordenes
     * @param robot instancia del robot
     */
    @Override
    public void confirmarOrden(Robot robot) {
        System.out.println("ERROR: No puedes confirmar una orden si el robot está dormido.");
    }

    /**
     * Cancelar una orden, pero en este estado no puede
     * @param robot instancia del robot
     */
    @Override
    public void cancelarOrden(Robot robot) {
        System.out.println("ERROR: No hay ninguna orden activa que cancelar.");
    }

    /**
     * Intenta preparar una orden, pero muestra un error 
     * @param robot instancia de un robot
     */
    @Override
    public void preparar(Robot robot) {
        System.out.println("ERROR: El robot debe atender una orden antes de poder prepararla.");
    }
    /**
     * Intenta entregar una orden, pero muestra un error
     * @param robot instancia del robot
     */
    @Override
    public void entregar(Robot robot) {
        System.out.println("ERROR: No hay ninguna orden lista para entregar.");
    }
}