package threads;

public class Producer extends Thread {

	private StoreRoom storeRoom;
	private int number;

	public Producer(StoreRoom storeRoom, int number) {
		this.storeRoom = storeRoom;
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			storeRoom.put(i);
			System.out.println("Producer # " + this.number + " put: " + i);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
		}
	}
}
