package problems.multipleThreadsGreetingInReverseOrder;

public class MultipleThreadsGreetingInReverseOrderTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		int size = 15;
		Thread [] createdThreads = new Thread[size];
		for(int i=size; i>0; i--) {
			Thread dependentThread = null;
			if(i!=size)
				dependentThread = createdThreads[i];
			Thread antThread = new AntThread(dependentThread, "Thread-"+i, i);
			createdThreads[i-1] = antThread;
		}
		
		//Starting the last thread first, as the join condition will work only when dependent thread is runnning
		for(int j=createdThreads.length-1; j>=0; j--) {
			createdThreads[j].start();
		}
		
	}

}
