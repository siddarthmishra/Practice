package threads;

public class BalancedParanthesis extends Thread {

	private String name;

	public BalancedParanthesis(String name) {
		this.name = name;
	}

	public void run() {
		printBalancedParanthesis();
	}

	// remove synchronized and see out put
	public void printBalancedParanthesis() {
		synchronized (BalancedParanthesis.class) {
			try {
				System.out.print("[");
				Thread.sleep(1500);
				System.out.print("(");
				Thread.sleep(1500);
				System.out.print(this.name);
				Thread.sleep(1500);
				System.out.print(")");
				Thread.sleep(1500);
				System.out.println("]");
				Thread.sleep(1500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		BalancedParanthesis bp1 = new BalancedParanthesis("BP1");
		BalancedParanthesis bp2 = new BalancedParanthesis("BP2");
		bp1.start();
		bp2.start();
	}

}
