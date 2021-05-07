package linefollow_semaphore;

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
			int v = app.getParallelLightSensorTask().getValue();
		      
		      System.out.println(v);
		      if (v < 100)  // black
		        gear.forward();
		      else if (v < 900)  // green
		        gear.rightArc(0.1);
		      else if (v > 900)  // yellow
		        gear.leftArc(0.1);
		      
		      //gear.rightArc(0.1);
			try {
				Thread.sleep(5L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Gear getGear() {
		return this.gear;
	}

}
