package pizzabot.robot;

public class Entregando implements RobotState {

    public void llamar(Robot robot) {
        System.out.println("ERROR: El robot está ocupado, por favor espere a que termine la entrega.");
    }

    public void confirmarOrden(Robot robot) {
        System.out.println("ERROR: No se puede confirmar una orden ahora.");
    }

    public void cancelarOrden(Robot robot) {
        System.out.println("ERROR: La orden ya fue preparada y no se puede cancelar.");
    }

    public void preparar(Robot robot) {
        System.out.println("ERROR: La orden ya ha sido preparada.");
    }

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