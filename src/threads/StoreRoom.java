package threads;

public class StoreRoom {

	private int contents;
	private boolean available = false;

	public int get_old() {
		available = false;
		return contents;
	}

	public void put_old(int value) {
		contents = value;
		available = true;
	}

	public synchronized int get() {
		while (false == available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return contents;
	}

	public synchronized void put(int value) {
		while (true == available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}
