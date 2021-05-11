package linefollow_semaphore;

public abstract class ParallelTask implements Runnable {

	protected LineFollowSemaphore app;
	protected Thread thread;
	
	protected ParallelTask(LineFollowSemaphore lineFollow) {
		super();
		this.app = lineFollow;
		this.thread = new Thread(this);
	}
	
	abstract void start();

}