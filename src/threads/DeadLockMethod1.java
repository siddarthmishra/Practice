package threads;

public class DeadLockMethod1 extends Thread {

	private DeadLock deadLock;

	public DeadLockMethod1(DeadLock deadLock) {
		this.deadLock = deadLock;
	}

	public void run() {
		try {
			deadLock.method1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
