package package1;

public class TrickyArray {
	private static final int[] numbers = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

	public static void main(String[] args) {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		printNumbers();
		for (int i = numbers.length - 1; i >= 0; i--) {
			numbers[i] = i;
		}
		printNumbers();
	}

	private static void printNumbers() {
		for (int i : numbers) {
			System.out.print(i);
		}
	}

}
