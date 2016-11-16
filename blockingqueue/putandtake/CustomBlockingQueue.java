package scratch.blockingqueue.putandtake;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rahul Malviya
 *This class is using condition queues concept to implement BlockingQueue's put and take operations.
 *Put and take operations will block if the queue is not in approapriate state to perform the requested
 *operation.
 *
 *We are creating two condition queues in this class (one for producer threads and one for consumer threads)
 *
 *producer threads condition queue - threads will wait until the queue size is not full
 *consumer threads condition queue - threads will wait until the queue is not empty
 * 
 */
public class CustomBlockingQueue {
	
	public CustomBlockingQueue(int size) {
		super();
		this.size = size;
		this.taskQueue = new LinkedList<>();
		
	}

	private int size;
	
	private Queue<String> taskQueue ;
	
	public synchronized void put(String task) throws InterruptedException {
		while(taskQueue.size()==this.size) {
			System.out.println(Thread.currentThread().getName()+" is waiting to put");
			wait();
		}
			
		System.out.println(Thread.currentThread().getName()+" is updating queue by adding - "+task);
		taskQueue.add(task);
		System.out.println("Queue size -- "+taskQueue.size());
		notifyAll();
	}
	
	public synchronized String take() throws InterruptedException {
		while(taskQueue.isEmpty()) {
			System.out.println(Thread.currentThread().getName()+" is waiting to take");
			wait();
		}
		String task = taskQueue.remove();
		System.out.println(Thread.currentThread().getName()+" is updating queue by removing - "+task);
		System.out.println("Queue size -- "+taskQueue.size());
		notifyAll();
		return task;
	}

	private void checkProvidedSize(int size) {
		if(size<=0)
			throw new RuntimeException("Queue size should not be less than or equal to zero");
	}
}
