package scratch.blockingqueue.putandtake;

public class ConsumerThread extends Thread {
	
	private String threadName;
	
	private CustomBlockingQueue customBlockingQueue;

	public ConsumerThread(CustomBlockingQueue customBlockingQueue, String threadName) {
		super(threadName);
		this.threadName = threadName;
		this.customBlockingQueue = customBlockingQueue;
	}

	@Override
	public void run() {
		try {
			String task = customBlockingQueue.take();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
}
