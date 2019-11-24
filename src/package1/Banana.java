package package1;

import java.io.Serializable;

public class Banana extends Fruit{
	int yellow = 4;
	public static void main(String[] args) {
		Banana b = new Banana();
		Banana b2 = new Banana();
	}
}

class Food implements Serializable {
	int good = 3;
}

class Fruit extends Food {
	int juice = 5;
}
