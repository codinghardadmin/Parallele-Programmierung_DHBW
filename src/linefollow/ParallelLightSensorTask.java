package linefollow;

import ch.aplu.robotsim.LightSensor;

public class ParallelLightSensorTask extends ParallelTask implements Runnable {

	private String name;
	private LightSensor lightSensor;
	private int value = -1;

	public ParallelLightSensorTask(LightSensor lightSensor, LineFollow lineFollow, String name) {
		super(lineFollow);
		this.name = name;
		this.lightSensor = lightSensor;
	}
	
	@Override
	public void start() {
		lightSensor.activate(true);
		thread.start();
	}
	
	@Override
	public void run() {
		for (;;) {
			this.value = lightSensor.getValue();
		}
	}
	
	public LightSensor getLightSensor() {
		return this.lightSensor;
	}
	
	public synchronized int getValue() {
		//System.out.println(getName() + "=" + value);
		return value;
	}

	public String getName() {
		return name;
	}

}
