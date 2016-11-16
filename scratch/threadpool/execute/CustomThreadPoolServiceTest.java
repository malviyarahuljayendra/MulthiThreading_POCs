package scratch.threadpool.execute;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomThreadPoolServiceTest {

	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5);
		CustomThreadPoolService customThreadPoolService
		 = new CustomThreadPoolService(2, queue);
		for(int i=0; i<=5; i++) 
		{
			int [] index = {i};
			Runnable task = ()->{System.out.println("Task - "+index[0]+" is being executed by the thread - "+Thread.currentThread().getName());};
			customThreadPoolService.execute(task);
		}
	}

}
