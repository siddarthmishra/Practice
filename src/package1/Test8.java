package package1;

public class Test8 {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("DBS");
			}
		};

		Thread t = new Thread(r) {
			public void run() {
				System.out.println("ASIA");
			}
		};
		t.start();
	}

}
