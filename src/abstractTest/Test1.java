package abstractTest;

import java.io.IOException;

public class Test1{

	public static void main(String[] args) throws Exception {
		
		System.out.println("main(String[] args)");
		
		Abstract1 a1 = new Abstract1() {

		@Override
		public int add() {
			return 0;
		}
		
		@Override
		public void sum(int a, int b) {
			System.out.println("---");	
		}

		@Override
		public void sum(int a) {
			// TODO Auto-generated method stub
			
		}
		
	};
	a1.sum(10, 20);
	System.out.println(a1.add());
	
	Abstract1.main(null);
	a1.main(null);
	}

	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void sum(int a) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}
	
	public void m1() {
		
	}
	
	public int m1(int a) throws IOException{
		System.out.println("int-m1");
		return a;
	}
	
	public int m1(String a) throws Exception{
		System.out.println("int-m1");
		return a.length();
	}
	
	public static void main() {
		System.out.println("main()");
	}

}
