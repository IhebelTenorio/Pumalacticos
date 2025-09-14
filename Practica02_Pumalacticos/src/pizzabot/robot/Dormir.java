package pizzabot.robot; 

public class Dormir implements RobotState {

    public void llamar(Robot robot) {
        System.out.println("El robot se está despertando, calma...");
        robot.setEstado(robot.getEstadoAtendiendo());
    }

    public void confirmarOrden(Robot robot) {
        System.out.println("ERROR: No puedes confirmar una orden si el robot está dormido.");
    }

    public void cancelarOrden(Robot robot) {
        System.out.println("ERROR: No hay ninguna orden activa que cancelar.");
    }

    public void preparar(Robot robot) {
        System.out.println("ERROR: El robot debe atender una orden antes de poder prepararla.");
    }

    public void entregar(Robot robot) {
        System.out.println("ERROR: No hay ninguna orden lista para entregar.");
    }
}