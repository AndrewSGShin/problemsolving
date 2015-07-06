import java.util.*;

public class factorize {
	public static void main(String... args) {
		long number = Long.valueOf(args[0]);
		List<Long> factors = factorize(number);
		System.out.println(factors);

		assert(even(4));
		assert(even(77772));
		assert(!even(7));
		assert(!even(77777));

		assert(!odd(4));
		assert(!odd(77772));
		assert(odd(7));
		assert(odd(77777));
	}

	public static List<Long> factorize(long composite) {
		if (composite < 2) {
			throw new IllegalArgumentException("Only integer composites >= 2 are accepted, given [" + composite + "].");
		}
		List<Long> factors = new ArrayList<>();
		long middle = (long) Math.ceil(Math.sqrt(composite));
		for(long i = 2; i <= middle; i++) {
			if (composite % i == 0) {
				factors.add(i);
				composite = composite / i;
				middle = (long) Math.ceil(Math.sqrt(composite));
				i = 1; // reset the loop
			}
		}

		if (composite >= 2) {
			factors.add(composite);
		}

		return factors;
	}

	public static boolean even(int number) {
		return number << 31 == 0;
	}

	public static boolean odd(int number) {
		return number << 31 != 0;
	}
}