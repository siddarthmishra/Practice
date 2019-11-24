package package1;

public class Test9 {

	public static void main(String[] args) {
	}
}

interface TestA {
	float getRange(int low, int high);
}

interface TestB {
	float getAvg(int a, int b, int c);
}

abstract class TestAbstract implements TestA, TestB {

}

class TestAImpl implements TestA {
	public float getRange(int low, int high) {
		return 3.14f;
	}
}

interface TestC extends TestB {
	float getAvg(int a, int b, int c, int d);
}