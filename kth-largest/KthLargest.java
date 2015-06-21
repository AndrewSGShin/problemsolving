import java.util.TreeSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class KthLargest {

	private static Integer[] array = {1, 3, 2, 4, 3, 7, 44};
	private static int k = 3;

	public static void main (String... args) {
		Set<Integer> set = new TreeSet<Integer>(Arrays.<Integer>asList(array));
		Integer[] sorted = set.toArray(new Integer[set.size()]);
		System.out.println("The " + k + "th largest number in the array " + Arrays.toString(array) + " is " + sorted[sorted.length - k]);
	}

}