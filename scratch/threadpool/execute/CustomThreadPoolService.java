package scratch.threadpool.execute;

import java.util.concurrent.BlockingQueue;

public class CustomThreadPoolService {
	
	private long noOfThreads;
	
	private BlockingQueue<Runnable> blockingQueue;

	public CustomThreadPoolService(long noOfThreads, BlockingQueue<Runnable> blockingQueue) {
		super();
		checkConstructingArguments(noOfThreads, blockingQueue);
		this.noOfThreads = noOfThreads;
		this.blockingQueue = blockingQueue;
		createThreads();
	}
	
	private void checkConstructingArguments (long noOfThreads, BlockingQueue<Runnable> blockingQueue) {
		if(noOfThreads <= 0)
			throw new RuntimeException("No of threads specified should not be 0 or negative numbers");
		if(blockingQueue == null)
			throw new RuntimeException("Provided queue collection should not be null");
	}
	
	public void execute(Runnable runnableTask) {
		try {
			System.out.println("Putting the task - "+runnableTask+" in the blocking queue");
			blockingQueue.put(runnableTask);
		} catch (InterruptedException e) {
			// TODO need to think about the interruption while taking element from the queue
			Thread.currentThread().interrupt();
		}
	}
	
	private void createThreads() {
		for (long i = 0; i < noOfThreads; i++) {
			new Thread("Thread-"+i)
			{
				public void run()
				{
					try {
						while(true)
						{
							Runnable task = blockingQueue.take();
							System.out.println("Thread - "+this.currentThread().getName()+" is going to execute the task-----"+task);
							task.run();
						}
					} catch (InterruptedException e) {
						// TODO need to think about the interruption while taking element from the queue
						Thread.currentThread().interrupt();
					}
				}
			}.start();
		}
			
	}

}
