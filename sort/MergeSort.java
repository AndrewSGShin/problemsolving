class MergeSort {

	public static void main(String... args) {
		List<String> list = Arrays.asList(args);
		System.out.println(mergeSort(list));
	}

	/*
	 * Space complexity O(nlogn)
	 * Time complexity best case = O(nlogn), worst case = O(n2)
	 */
	private static <T extends Comparable<T>> List<T> mergeSort (List<T> list) {
		if (list == null) {
			throw new NullPointerException();
		}

		if (list.size() < 2) {
			return list;
		}

		if (list.size() == 2) {
			if (list.get(0).compareTo(list.get(1)) > 0) {
				T tmp = list.get(0);
				list.set(0, list.get(1));
				list.set(1, tmp);
			}
			return list;
		}

		int splitIndex = list.size() / 2;

		List<T> left = list.subList(0, splitIndex);
		List<T> right = list.subList(splitIndex, list.size());

		

		T pivot = list.get(0);

		for (T item : list) {
			if (item == pivot) {
				continue;
			}
			if (pivot.compareTo(item) > 0) {
				left.add(item);
			} else {
				right.add(item);
			}
		}

		left = quickSort(left);
		right = quickSort(right);

		left.add(pivot);
		left.addAll(right);

		return left;
	}
}