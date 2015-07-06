import java.util.*;

class primes {
	public static void main(String... args) {
		int n = Integer.valueOf(args[0]);
		System.out.println(primes1(n));
		System.out.println(primes2(n));
	}

	public static List<Integer> primes1(int n) {
		List<Integer> factors = new ArrayList<>();
		int i = 2;
		while (factors.size() != n) {
			if (isprime.isPrime(i)) {
				factors.add(i);
			}
			i++;
		}
		return factors;
	}

	public static List<Integer> primes2(int n) {
		List<Integer> factors = new ArrayList<>();
		factors.add(2);
		factors.add(3);
		int i = 2;
		while (factors.size() != n) {
			int product = product(factors, i);
			factors.add(product - 1);
			factors.add(product + 1);
			i++;
		}
		return factors;
	}

	private static int product(List<Integer> list, int n) {
		int product = 1;
		for (int i = 0; i < n; i++) {
			int multiplier = list.get(i);
			product *= multiplier;
		}
		return product;
	}
}