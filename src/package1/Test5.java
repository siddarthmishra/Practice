package package1;

public class Test5 {

	public static void main(String[] args) {
		Sim sim = new Jio();
		Airtel airtel = (Airtel) sim;
		System.out.println(airtel.callRate());
	}
}

class Sim {
	public String callRate() {
		return "Package";
	}
}

class Jio extends Sim {
	public String callRate() {
		return "Free";
	}
}

class Airtel extends Sim {
	public String callRate() {
		return "Per Second";
	}
}