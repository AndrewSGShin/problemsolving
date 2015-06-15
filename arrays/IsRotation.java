/*

Assume you have a method isSubstring (contains) which checks if one word is a substring of another. 
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g.,"waterbottle"is a rotation of"erbottlewat").

*/

class IsRotation {

	public static void main(String... args) {
		System.out.println(isRotation(args[0], args[1]));
	}

	static boolean isRotation(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		return (a + a).contains(b);
	}

}