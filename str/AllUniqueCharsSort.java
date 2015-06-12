import java.util.Arrays;

/*
 * Implement an algorithm to determine if a string has all unique characters. Don't use additional data structures.
 */
class AllUniqueCharsSort {

	public static void main(String... args) {
		Boolean allUnique = allUniqueChars(args[0]);
		if (allUnique) {
			System.out.println("All chars are unique.");
		} else {
			System.out.println("Not all chars are unique.");
		}
	}

	/*
	 * Space complexity O(1)
	 * Time complexity O(n)
	 */
	private static Boolean allUniqueChars (String str) {
		if (str == null) {
			throw new NullPointerException();
		}

		if (str.length() == 1) {
			return true;
		}

		char[] chars = str.toCharArray();
		Arrays.sort(chars);

		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == chars[i+1]) {
				return false;
			}
		}

		return true;
	}
}