package linefollow_mutex;

public abstract class ParallelTask implements Runnable {

	protected LineFollowMutex app;
	protected Thread thread;
	
	protected ParallelTask(LineFollowMutex lineFollow) {
		super();
		this.app = lineFollow;
		this.thread = new Thread(this);
	}
	
	abstract void start();

}