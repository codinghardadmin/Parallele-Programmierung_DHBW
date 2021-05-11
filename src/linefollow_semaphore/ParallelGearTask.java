package linefollow_semaphore;

import java.util.concurrent.Semaphore;

import ch.aplu.robotsim.Gear;

public class ParallelGearTask extends ParallelTask {
	
	private Gear gear;
	private Semaphore mutex = new Semaphore(1);

	public ParallelGearTask(Gear gear, LineFollowSemaphore lineFollow) {
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
		try {
            mutex.acquire();
            gear.leftArc(0.1);
        } catch (InterruptedException e) {
        	
        } finally {
            mutex.release();
        }
	}
	
	public void right() {
		try {
            mutex.acquire();
            gear.rightArc(0.1);
        } catch (InterruptedException e) {
        	
        } finally {
            mutex.release();
        }
	}
	
	public void forward() {
		try {
            mutex.acquire();
            gear.forward();
        } catch (InterruptedException e) {
        	
        } finally {
            mutex.release();
        }
	}


}
