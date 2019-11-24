package threads;

public class Consumer extends Thread {

	private StoreRoom storeRoom;
	private int number;

	public Consumer(StoreRoom storeRoom, int number) {
		this.storeRoom = storeRoom;
		this.number = number;
	}

	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = storeRoom.get();
			System.out.println("Consumer # " + this.number + " got: " + value);
		}
	}

}
