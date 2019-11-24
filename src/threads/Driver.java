package threads;

public class Driver {

	public static void main(String[] args) {
		StoreRoom sr = new StoreRoom();
		Producer p = new Producer(sr, 1);
		Consumer c = new Consumer(sr, 2);
		p.start();
		c.start();
	}

}
