package linefollow_mutex;

import ch.aplu.robotsim.LightSensor;

public class ParallelLightSensorTask extends ParallelTask implements Runnable {

	private String name;
	private LightSensor lightSensor;
	private int value = -1;
	private Object mutex = new Object();

	public ParallelLightSensorTask(LightSensor lightSensor, LineFollowMutex lineFollow, String name) {
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
	
	public int getValue() {
		synchronized (mutex) {
			return value;
		}
	}

	public String getName() {
		return name;
	}

}
