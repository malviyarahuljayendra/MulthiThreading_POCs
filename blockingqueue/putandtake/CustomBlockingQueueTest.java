package scratch.blockingqueue.putandtake;

public class CustomBlockingQueueTest {
	
	public static void main(String[] args) throws InterruptedException {
		CustomBlockingQueue customBlockingQueue = new CustomBlockingQueue(2);
		ProducerThread producerThread = new ProducerThread(customBlockingQueue);
		ConsumerThread consumerThread;
		for(int i=0; i<5; i++)
			new ConsumerThread(customBlockingQueue, "ConsumerThread-"+i).start();
		
		System.out.println("Main thread will sleep for 5 seconds");
		Thread.currentThread().sleep(500);
		producerThread.start();
		
	}

}
