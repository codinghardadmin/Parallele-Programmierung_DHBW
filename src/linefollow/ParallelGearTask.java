package linefollow;

import ch.aplu.robotsim.Gear;

public class ParallelGearTask extends ParallelTask {
	
	private Gear gear;

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
			int left = app.getParallelLightSensorTaskLeft().getValue();
			int right = app.getParallelLightSensorTaskRight().getValue();
		      
			if (left < 200) {
				gear.leftArc(0.1);
			} else if (right < 200) {
				gear.rightArc(0.1);
			} else {
				gear.forward();
			}
		}
	}
	
	public synchronized Gear getGear() {
		return this.gear;
	}

}
