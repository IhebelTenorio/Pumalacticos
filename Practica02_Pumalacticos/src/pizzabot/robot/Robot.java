package pizzabot.robot;

public class Robot {
    RobotState state;

    public Robot(){
        state = new Dormir();
    }

    public void despierta() {
        state = new Atender(this);
    }

    protected void preparar(){}
}
