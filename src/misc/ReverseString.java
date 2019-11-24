package misc;

public class ReverseString {

	public static void main(String[] args) {

		ReverseString rs = new ReverseString();
		String s = "ABCDE";
		System.out.println(rs.reverseString(s));
		
		Integer a = null;
		int b = a;
		System.out.println(b);

	}

	public String reverseString(final String s) {
		String ls = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.println(s.charAt(i));
			ls = ls + s.charAt(i);
		}
		return ls;
	}

}
