// SimEx14a.java
// Event driven ultrasonic sensor

import ch.aplu.robotsim.*;
import java.awt.Color;
import java.awt.Point;

public class SimEx14a implements UltrasonicListener
{
  private LegoRobot robot = new LegoRobot();
  private Gear gear = new Gear();

  public SimEx14a()
  {
    robot.addPart(gear);
    UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
    robot.addPart(us);
    us.setBeamAreaColor(Color.green);
    us.setProximityCircleColor(Color.lightGray);
    us.addUltrasonicListener(this, 50);

    gear.setSpeed(15);
    gear.forward();
  }

  public void far(SensorPort port, int value)
  {
    robot.getGameGrid().setTitle("far event");
  }

  public void near(SensorPort port, int value)
  {
    robot.getGameGrid().setTitle("near event");
    gear.backward(2000);
    gear.left(1000);
    gear.forward();
  }

  public static void main(String[] args)
  {
    new SimEx14a();
  }

  // ------------------ Environment --------------------------
  static
  {
    Point[] mesh_hbar =
    {
      new Point(200, 10), new Point(-200, 10),
      new Point(-200, -10), new Point(200, -10)
    };
    Point[] mesh_vbar =
    {
      new Point(10, 200), new Point(-10, 200),
      new Point(-10, -200), new Point(10, -200)
    };
    RobotContext.useTarget("sprites/bar0.gif", mesh_hbar, 250, 100);
    RobotContext.useTarget("sprites/bar0.gif", mesh_hbar, 250, 400);
    RobotContext.useTarget("sprites/bar1.gif", mesh_vbar, 100, 250);
    RobotContext.useTarget("sprites/bar1.gif", mesh_vbar, 400, 250);
  }
}
