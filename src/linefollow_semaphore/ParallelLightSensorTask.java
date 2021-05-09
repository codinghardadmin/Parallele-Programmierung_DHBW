package linefollow_semaphore;

import java.util.concurrent.Semaphore;

import ch.aplu.robotsim.LightSensor;

public class ParallelLightSensorTask extends ParallelTask implements Runnable {

	private String name;
	private LightSensor lightSensor;
	private int value = -1;
	private Semaphore mutex = new Semaphore(1);

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
		try {
            mutex.acquire();
            return value;
        } catch (InterruptedException e) {
            return -1;
        } finally {
            mutex.release();
        }
	}

	public String getName() {
		return name;
	}

}
