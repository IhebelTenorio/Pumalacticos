package pizzabot;
import pizzabot.robotState.*;

public class Robot {
    RobotState state;

    public Robot(){
        state = new Atender();
    }
}
