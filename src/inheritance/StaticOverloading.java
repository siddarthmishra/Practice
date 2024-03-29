package inheritance;

public class StaticOverloading {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		P p = new P();
		p.m1();
		
		C c = new C();
		c.m1();
		
		P p1 = new C();
		p1.m1();
		
	}

}

class P {
	public static void m1() {
		System.out.println("class P");
	}
}

class C extends P {
	public static void m1() {
		System.out.println("class C");
	}
}
