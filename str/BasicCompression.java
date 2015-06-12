/*

Implement a method to perform basic string compression using the counts of repeated characters. 
For example, the string aabcccccaaa would become a2b1c5a3. 
If the compressed string would not become smaller than the original string, return the original string.

*/


class BasicCompression {
	
	public static void main (String... args) {
		String original = args[0];
		System.out.println("Compressed: " + compressed(original));
		System.out.println("Compressed2: " + compressed2(original));
		System.out.println("Compressed3: " + compressed3(original));
	}

	static String compressed(String str) {
		char[] original = str.toCharArray();
		char[] compressed = new char[original.length * 2]; // worst case when string contains no same char sequences
		
		int compressedLength = 0;
		int sequence = 1;
		char previous = original[0];
		for (int i = 1; i < original.length; i++) {
			if (previous == original[i]) {
				sequence++;
			} else {
				compressed[compressedLength++] = previous;
				char[] sequenceChars = String.valueOf(sequence).toCharArray();
				for (int j = 0; j < sequenceChars.length; j++) {
					compressed[compressedLength++] = sequenceChars[j];
				}
				sequence = 1;
			}
			previous = original[i];
			if (compressedLength > original.length) {
				return str;
			}
		}

		// handle last char 
		compressed[compressedLength++] = previous;
		char[] sequenceChars = String.valueOf(sequence).toCharArray();
		for (int j = 0; j < sequenceChars.length; j++) {
			compressed[compressedLength++] = sequenceChars[j];
		}


		if (compressedLength < original.length) {
			char[] result = new char[compressedLength];
			System.arraycopy(compressed, 0, result, 0, compressedLength);
			return new String(result);
		} else {
			return str;
		}
	}

	static String compressed2(String original) {
		StringBuilder compressed = new StringBuilder(original.length() * 2);
		
		int sequence = 1;
		char previous = original.charAt(0);
		for (int i = 1; i < original.length(); i++) {
			if (previous == original.charAt(i)) {
				sequence++;
			} else {
				compressed.append(previous).append(sequence);
				sequence = 1;
			}
			previous = original.charAt(i);
			if (compressed.length() >= original.length()) {
				return original;
			}
		}

		// handle last char 
		compressed.append(previous).append(sequence);

		if (compressed.length() < original.length()) {
			return compressed.toString();
		} else {
			return original;
		}
	}

	static String compressed3(String original) {
		String compressed = "";
		
		int sequence = 1;
		char previous = original.charAt(0);
		for (int i = 1; i < original.length(); i++) {
			if (previous == original.charAt(i)) {
				sequence++;
			} else {
				compressed += "" + previous + sequence;
				sequence = 1;
			}
			previous = original.charAt(i);
			if (compressed.length() >= original.length()) {
				return original;
			}
		}

		// handle last char 
		compressed += "" + previous + sequence;

		if (compressed.length() < original.length()) {
			return compressed;
		} else {
			return original;
		}
	}
}