package test;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.Tools;

public class TestMain {
	public static void main(String[] args) {
		System.out.println("Test");
		
		
		LegoRobot robot = new LegoRobot();
	    Gear gear = new Gear();
	    robot.addPart(gear);

	    gear.forward();
	    Tools.delay(2000);
	    gear.left(2000);
	    gear.forward(2000);
	    gear.leftArc(0.2, 2000);
	    gear.forward(2000);
	    gear.leftArc(-0.2, 2000);
	    robot.exit();
	}
}
