package problems.multipleThreadsGreetingInReverseOrder;

public class AntThread extends Thread {
	
	private Thread dependentThread;
	private String threadName;
	private int index;
	public AntThread(Thread dependentThread, String threadName, int index) {
		super(threadName);
		this.dependentThread = dependentThread;
		this.threadName = threadName;
		this.index = index;
	}
	
	public void run() {
		if(dependentThread!=null) {
			try {
				dependentThread.join();
			} catch (InterruptedException e) {
				this.interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName()+" is saying - HelloWorld");
	}

}
