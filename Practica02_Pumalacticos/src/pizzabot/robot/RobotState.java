package pizzabot.robot; 

public interface RobotState {


    void llamar(Robot robot);

    void confirmarOrden(Robot robot);

    void cancelarOrden(Robot robot);

    void preparar(Robot robot);

    void entregar(Robot robot);
    
}
