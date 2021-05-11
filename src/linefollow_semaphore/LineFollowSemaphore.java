package linefollow_semaphore;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;


public class LineFollowSemaphore {
	
	private ParallelGearTask gearTask;
	private ParallelLightSensorTask lightSensorTaskLeft;
	private ParallelLightSensorTask lightSensorTaskRight;
	
	static
	  {
	    RobotContext.setStartPosition(70, 380);
	    RobotContext.setStartDirection(-90);
	    RobotContext.useBackground("sprites/linefollow2.png");
	  }
	
	public LineFollowSemaphore() {
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
	    
	    for (;;) {
	    	int left = getParallelLightSensorTaskLeft().getValue();
			int right = getParallelLightSensorTaskRight().getValue();
		      
			if (left < 200) {
				gearTask.left();
			} else if (right < 200) {
				gearTask.right();
			} else {
				gear.forward();
			}
			
			try {
				Thread.sleep(10L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
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
		new LineFollowSemaphore();
	}
}
