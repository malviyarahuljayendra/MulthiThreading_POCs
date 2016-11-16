package scratch.blockingqueue.putandtake;

public class ProducerThread extends Thread {
	
	private CustomBlockingQueue customBlockingQueue;

	public ProducerThread(CustomBlockingQueue customBlockingQueue) {
		super("ProducerThread");
		this.customBlockingQueue = customBlockingQueue;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			String task = "Task-"+i;
			try {
				customBlockingQueue.put(task);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
	}
	
}
