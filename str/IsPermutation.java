import java.util.HashMap;

class IsPermutation {
	public static void main(String... args) {
		System.out.println(isPermutation(args[0], args[1]));
	}

	/**
	 * Space complexity O(logn)
	 * Time complexity O(2n)
	 */
	private static boolean isPermutation(String a, String b) {
		if (a == null || b == null) {
			throw new NullPointerException();
		}

		if (a.length() != b.length()) {
			return false;
		}

		int length = a.length();

		HashMap<Character, Integer> chars = new HashMap<>();

		for (int i = 0; i < length; i++) {
			Character c = a.charAt(i);
			if (chars.containsKey(c)) {
				chars.put(c, chars.get(c) + 1);
			} else {
				chars.put(c, 1);
			}
		}

		for (int i = 0; i < length; i++) {
			Character c = b.charAt(i);
			if (!chars.containsKey(c)) {
				return false;
			}

			int count = chars.get(c);
			if (count == 0) {
				return false;
			}

			chars.put(c, count - 1);
		}

		return true;
	}
}