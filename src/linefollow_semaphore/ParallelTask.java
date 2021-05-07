package linefollow_semaphore;

public abstract class ParallelTask implements Runnable {

	protected LineFollow app;
	protected Thread thread;
	
	protected ParallelTask(LineFollow lineFollow) {
		super();
		this.app = lineFollow;
		this.thread = new Thread(this);
	}
	
	abstract void start();

}