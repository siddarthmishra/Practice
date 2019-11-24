package lambda;

public class LambdaEx {

	public static void main(String[] args) {
		Interf I = (a,b) -> a+b;
		System.out.println(I.add(I.x, I.y));
		
		Runnable r = () -> {
							for(int i = 1; i<=10; i++) {
								System.out.println("Child Thread");
							}
							};
							
		Runnable r1 = new Runnable()
		{
			@Override
			public void run() {
				for(int i = 1; i<=10; i++) {
					System.out.println("Anonymous Class");
				}				
			}
		};
		
		Thread t = new Thread(r);
		Thread t2 = new Thread(r1);
		Thread t3 = new Thread(() -> {for(int i = 1; i<=10; i++) {
										System.out.println("Lambda Arguement");
									}
								});
		t.start();
		t2.start();
		t3.start();
		for(int i = 1; i<=10; i++) {
			System.out.println("Main Thread");
		}
	}

}
