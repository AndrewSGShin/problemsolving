import java.util.*;

class reducefraction {
	public static void main(String... args) {
		boolean debug = false;
		if (args.length > 1 && args[1].equals("--debug")) {
			debug = true;
		} 

		String[] fraction = args[0].split("/");
		long numerator = Long.valueOf(fraction[0]);
		long denominator = Long.valueOf(fraction[1]);

		if (debug) {
			System.out.println("Numerator [" + numerator + "]");
			System.out.println("Denominator [" + denominator + "]");
		}
		

		// convert to map
		HashMap<Long, Integer> numeratorFactorCounts = new HashMap<>();
		for (Long factor : factorize.factorize(numerator)) {
			Integer count = numeratorFactorCounts.get(factor);
			if (count == null) {
				numeratorFactorCounts.put(factor, 1);
			} else {
				numeratorFactorCounts.put(factor, count + 1);
			}  
		}
		
		if (debug) System.out.println(numeratorFactorCounts);

		// convert to map
		HashMap<Long, Integer> denominatorFactorCounts = new HashMap<>();
		for (Long factor : factorize.factorize(denominator)) {
			Integer count = denominatorFactorCounts.get(factor);
			if (count == null) {
				denominatorFactorCounts.put(factor, 1);
			} else {
				denominatorFactorCounts.put(factor, count + 1);
			}  
		}
		if (debug) System.out.println(denominatorFactorCounts);

		// reduce
		for (Long factor : numeratorFactorCounts.keySet()) {
			Integer denominatorFactorCount = denominatorFactorCounts.get(factor);
			if (denominatorFactorCount != null) {
				if (debug) System.out.println("Common factor [" + factor + "]");
				Integer numeratorFactorCount = numeratorFactorCounts.get(factor);
				if (denominatorFactorCount > numeratorFactorCount) {
					numeratorFactorCounts.put(factor, 0);
					denominatorFactorCounts.put(factor, denominatorFactorCount - numeratorFactorCount);
				} else {
					denominatorFactorCounts.put(factor, 0);
					numeratorFactorCounts.put(factor, numeratorFactorCount - denominatorFactorCount);
				}
			}
		}

		if (debug) System.out.println(numeratorFactorCounts);
		if (debug) System.out.println(denominatorFactorCounts);

		long reducedNumerator = 1;
		for (Long factor : numeratorFactorCounts.keySet()) {
			int count = numeratorFactorCounts.get(factor);
			if (count != 0) {
				reducedNumerator *= (long) Math.pow(factor, count);
			}
		}

		long reducedDenominator = 1;
		for (Long factor : denominatorFactorCounts.keySet()) {
			int count = denominatorFactorCounts.get(factor);
			if (count != 0) {
				reducedDenominator *= (long) Math.pow(factor, count);
			}
		}

		System.out.println(reducedNumerator + "/" + reducedDenominator);
	}
}