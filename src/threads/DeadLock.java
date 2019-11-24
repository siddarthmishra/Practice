package threads;

public class DeadLock {

	public static Object object1 = new Object();
	public static Object object2 = new Object();

	public void method1() throws InterruptedException {
		synchronized (object1) {
			System.out.println("method1() holds lock on object1 : " + Thread.holdsLock(object1));
			System.out.println("method1() holds lock on object2 : " + Thread.holdsLock(object2));
			Thread.sleep(1000);
			synchronized (object2) {
				doSomething("method1()");
			}
		}
	}

	public void method2() throws InterruptedException {
		synchronized (object2) {
			System.out.println("method2() holds lock on object2 : " + Thread.holdsLock(object2));
			System.out.println("method2() holds lock on object1 : " + Thread.holdsLock(object1));
			Thread.sleep(1000);
			synchronized (object1) {
				doSomething("method2()");
			}
		}
	}

	public static void doSomething(String string) {
		System.out.println("doSomething from " + string);
	}

}
