package linefollow;

import ch.aplu.robotsim.LightSensor;

public class ParallelLightSensorTask extends ParallelTask implements Runnable {

	private LightSensor lightSensor;
	private int value = -1;

	public ParallelLightSensorTask(LightSensor lightSensor, LineFollow lineFollow) {
		super(lineFollow);
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
		return value;
	}
	
}
