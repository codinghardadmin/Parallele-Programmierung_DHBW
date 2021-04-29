package linefollow;
// SimEx10.java
// One light sensor, one touchsensor, road follower

import ch.aplu.robotsim.*;

public class SimEx10
{
  public SimEx10()
  {
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    LightSensor ls = new LightSensor(SensorPort.S3);
    TouchSensor ts = new TouchSensor(SensorPort.S1);
    robot.addPart(gear);
    robot.addPart(ls);
    robot.addPart(ts);
    ls.activate(true);

    while (true)
    {
      int v = ls.getValue();
      
      System.out.println(v);
      if (v < 100)  // black
        gear.forward();
      else if (v < 900)  // green
        gear.rightArc(0.1);
      else if (v > 900)  // yellow
        gear.leftArc(0.1);
     if (ts.isPressed())
      {  
        gear.stop();
        break;
      }
    }
  }

  public static void main(String[] args)
  {
    new SimEx10();
  }

  // ------------------ Environment --------------------------
  static
  {
    RobotContext.setStartPosition(50, 380);
    RobotContext.setStartDirection(-90);
    RobotContext.useBackground("sprites/road.gif");
    //RobotContext.useBackground("sprites/linefollow.gif");
    RobotContext.useObstacle("sprites/chocolate.gif", 400, 50);
  }
}
