package threads;

public class DeadLockMethod2 extends Thread {

	private DeadLock deadLock;

	public DeadLockMethod2(DeadLock deadLock) {
		this.deadLock = deadLock;
	}

	public void run() {
		try {
			deadLock.method2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
