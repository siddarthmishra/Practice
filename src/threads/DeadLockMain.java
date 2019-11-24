package threads;

public class DeadLockMain {

	public static void main(String[] args) {
		DeadLock deadLock = new DeadLock();
		DeadLockMethod1 dlm1 = new DeadLockMethod1(deadLock);
		DeadLockMethod2 dlm2 = new DeadLockMethod2(deadLock);
		dlm1.start();
		dlm2.start();
	}
}
