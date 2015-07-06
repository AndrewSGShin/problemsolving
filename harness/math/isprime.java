class isprime {
	public static void main(String... args) {
		assert(isPrime(2));
		assert(isPrime(7));
		assert(!isPrime(4));

		System.out.println(isPrime(Integer.valueOf(args[0])));
	}

	public static boolean isPrime(int number) {
		if (number < 2) {
			throw new IllegalArgumentException("Only integer composites >= 2 are accepted, given [" + number + "].");
		}

		if (number == 2) {
			return true;
		}

		int middle = (int) Math.ceil(Math.sqrt(number));
		for(int i = 2; i <= middle; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}