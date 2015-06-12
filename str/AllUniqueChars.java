import java.util.Set;
import java.util.HashSet;

/*
 * Implement an algorithm to determine if a string has all unique characters.
 */
class AllUniqueChars {

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

		Set<Character> unique = new HashSet<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (unique.contains(str.charAt(i))) {
				return false;
			} else {
				unique.add(str.charAt(i));
			}
		}

		return true;
	}
}