package linefollow_semaphore;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;


public class LineFollow {
	
	private ParallelGearTask gearTask;
	private ParallelLightSensorTask lightSensorTaskLeft;
	private ParallelLightSensorTask lightSensorTaskRight;

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
	    LightSensor links = new LightSensor(SensorPort.S2);
	    LightSensor rechts = new LightSensor(SensorPort.S1);
	    
	    robot.addPart(gear);
	    robot.addPart(links);
	    robot.addPart(rechts);
	    
	    gearTask = new ParallelGearTask(gear, this);
	    lightSensorTaskLeft = new ParallelLightSensorTask(links, this, "LEFT");
	    lightSensorTaskRight = new ParallelLightSensorTask(rechts, this, "RIGHT");
	    
	    gearTask.start();
	    lightSensorTaskLeft.start();
	    lightSensorTaskRight.start();
	}
	
	public  ParallelGearTask getParallelGearTask() {
		return gearTask;
	}

	public  ParallelLightSensorTask getParallelLightSensorTaskLeft() {
		return lightSensorTaskLeft;
	}
	
	public  ParallelLightSensorTask getParallelLightSensorTaskRight() {
		return lightSensorTaskRight;
	}
	
	public static void main(String[] args) {
		new LineFollow();
	}
}
