package linefollow;

import ch.aplu.robotsim.LightSensor;

public class ParallelLightSensorTask implements Runnable {

	private LineFollow app;
	private LightSensor lightSensor;
	private Thread thread;
	private int value = -1;

	public ParallelLightSensorTask(LightSensor lightSensor, LineFollow lineFollow) {
		this.app = lineFollow;
		this.lightSensor = lightSensor;
		thread = new Thread(this);
		thread.start();
	}
	
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
	
	public int getValue() {
		return value;
	}
	
}
