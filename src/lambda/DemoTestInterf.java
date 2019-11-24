package lambda;

public class DemoTestInterf {

	public static void main(String[] args) {
		
		TestInterf2 tf2 = new TestInterf2();
//		tf2.add(50, 100);
		System.out.println(tf2.add(50, 100));
		
		Interf i = new TestInterf2();
		System.out.println(i.x);

	}

}
class TestInterf2 implements Interf{

	@Override
	public int add(int x, int y) {
		return x + y;
	}
	
}
