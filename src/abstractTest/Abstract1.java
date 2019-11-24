package abstractTest;

public abstract class Abstract1 {

	public static void main(String[] args) throws Exception{
		
		System.out.println("Abstract class main method");
	}
	
	public void sum(int a,int b) throws Exception{
		System.out.println(a+b);
	}
	
	public abstract int add();
	
	public abstract void sum(int a) throws Exception;

}
