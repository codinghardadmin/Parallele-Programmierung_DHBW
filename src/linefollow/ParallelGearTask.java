package linefollow;

import ch.aplu.robotsim.Gear;

public class ParallelGearTask implements Runnable {
	
	private LineFollow app;
	private Gear gear;
	private Thread thread;

	public ParallelGearTask(Gear gear, LineFollow lineFollow) {
		this.app = lineFollow;
		this.gear = gear;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		for (;;) {
			int v = app.getParallelLightSensorTask().getValue();
		      
		      System.out.println(v);
		      /*if (v < 100)  // black
		        gear.forward();
		      else if (v < 900)  // green
		        gear.rightArc(0.1);
		      else if (v > 900)  // yellow
		        gear.leftArc(0.1);*/
		      
		      gear.rightArc(0.1);
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
