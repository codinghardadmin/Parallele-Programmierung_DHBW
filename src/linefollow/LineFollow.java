package linefollow;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;

public class LineFollow {
	
	private ParallelGearTask gearTask;
	private ParallelLightSensorTask lightSensorTask;

	/*static
	  {
	    RobotContext.setStartPosition(40, 460);
	    RobotContext.setStartDirection(-90);
	    RobotContext.useBackground("sprites/road.gif");
	    RobotContext.useObstacle("sprites/chocolate.gif", 400, 50);
	  }*/
	
	static
	  {
	    RobotContext.setStartPosition(70, 380);
	    RobotContext.setStartDirection(-90);
	    RobotContext.useBackground("sprites/linefollow2.png");
	  }
	
	public LineFollow() {
		System.out.println("LineFollow App RobotSim");
		
		LegoRobot robot = new LegoRobot();
		
		Gear gear = new Gear();
	    LightSensor ls = new LightSensor(SensorPort.S3);
	    
	    robot.addPart(gear);
	    robot.addPart(ls);
	    
	    gearTask = new ParallelGearTask(gear, this);
	    lightSensorTask = new ParallelLightSensorTask(ls, this);
	    
	    gearTask.start();
	    lightSensorTask.start();
	}
	
	public ParallelGearTask getParallelGearTask() {
		return gearTask;
	}

	public ParallelLightSensorTask getParallelLightSensorTask() {
		return lightSensorTask;
	}
	
	public static void main(String[] args) {
		new LineFollow();
	}
}
