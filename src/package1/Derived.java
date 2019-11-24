package package1;

public class Derived extends Base{

	public static void main(String[] args) {

	}
	
	protected final void getDetails() {
		System.out.println("Derived class");
	}
}

class Base {
	protected final void getDetails() {
		System.out.println("Base class");
	}
}
