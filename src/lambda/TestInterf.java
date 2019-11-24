package lambda;

public class TestInterf implements Interf{

	public static void main(String[] args) {
		
		TestInterf tf = new TestInterf();
		System.out.println("sum of above is " + tf.add(x, y));
//		x = 50;
		Interf i = new TestInterf();
		i.add(x, y);
		System.out.println(i.x);
		System.out.println(i.y);
//		i.y = 500;
	}

	@Override
	public int add(int x, int y) {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		return x + y;
	}

}
