package pizzabot;
import pizzabot.robotState.*;

public class Robot {
    RobotState state;

    public Robot(){
        state = new Dormir();
    }

    public void despierta() {
        state = new Atender();
    }
}
