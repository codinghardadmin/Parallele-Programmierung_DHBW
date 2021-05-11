package linefollow_mutex;

import ch.aplu.robotsim.Gear;

public class ParallelGearTask extends ParallelTask {
	
	private Gear gear;
	private Object mutex = new Object();

	public ParallelGearTask(Gear gear, LineFollow lineFollow) {
		super(lineFollow);
		this.app = lineFollow;
		this.gear = gear;
	}
	
	@Override
	void start() {
		thread.start();
	}
	
	@Override
	public void run() {
		for (;;) {
			
		}
	}
	
	public Gear getGear() {
		return this.gear;
	}
	
	public void left() {
		synchronized (mutex) {
			gear.leftArc(0.1);
		}
	}
	
	public void right() {
		synchronized (mutex) {
			gear.rightArc(0.1);
		}
	}
	
	public void forward() {
		synchronized (mutex) {
			gear.forward();
		}
	}

}
