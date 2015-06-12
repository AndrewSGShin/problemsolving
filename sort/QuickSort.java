import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class QuickSort {

	public static void main(String... args) {
		List<String> list = Arrays.asList(args);
		System.out.println("randomly sorted: " +  quickSort(list));
		LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(args));
		quickSortLinkedListInPlace(linkedList);
		System.out.println("sequentially sorted: " +  linkedList);
	}

	/*
	 * Space complexity O(nlogn)
	 * Time complexity best case = O(nlogn), worst case = O(n2)
	 *
	 * Space complexity can be decreased if we reuse `list` for storing `write` elements but than will increase time complexity for ArrayLists.
	 * We can also use Linked List for that purpose to reduce space complexity while preserving time complexity.
	 *
	 * @param {list} Pointer to storage in memory 
	 */
	private static <T extends Comparable<T>> List<T> quickSort (List<T> list) {
		if (list == null) {
			throw new NullPointerException();
		}

		// time 1: read
		if (list.size() < 2) {
			return list;
		}

		// space n: alloc (`left` will hold the whole list at the end of this function)
		List<T> left = new ArrayList<T>(list.size());
		
		// space n - 1: alloc
		List<T> right = new ArrayList<T>(list.size() - 1);

		// time 1: read
		T pivot = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			// time n - 1: read
			T item = list.get(i);

			// time n - 1: compare 
			// time n - 1: store
			if (pivot.compareTo(item) > 0) {
				left.add(item);
			} else {
				right.add(item);
			}
		}

		// How many items goes to `left` and `write` is determined at runtime. Let `write` contain k items and `left` contain (n - 1 - k) items

		left = quickSort(left);
		right = quickSort(right);

		// time 1: store
		left.add(pivot);

		// time k: store
		left.addAll(right);

		return left;
	}

	/*
	 * Space complexity O(1) very tiny. In fact we allocate only small thing beyong original list.
	 * Time complexity average/best case = O(nlogn), worst case = O(n2)
	 */
	private static <T extends Comparable<T>> LinkedList<T> quickSortLinkedList(LinkedList<T> list) {
		if (list == null) {
			throw new NullPointerException();
		}

		if (list.size() < 2) {
			return list;
		}

		LinkedList<T> left = new LinkedList<T>();

		T pivot = list.removeFirst();

		Iterator<T> iterator = list.listIterator(0);

		while (iterator.hasNext()) {
			T item = iterator.next();
			if (pivot.compareTo(item) > 0) {
				left.add(item);
				iterator.remove();
			}
		}

		iterator = null;

		left = quickSortLinkedList(left);	
		list = quickSortLinkedList(list);

		left.add(pivot);
		left.addAll(list);

		return left;
	}

	/**
	 * Sorts linked list in place using quicksort algorithm
	 */
	private static <T extends Comparable<T>> void quickSortLinkedListInPlace(LinkedList<T> list) {
		if (list == null) {
			throw new NullPointerException();
		}

		if (list.size() < 2) {
			return;
		}

		LinkedList<T> right = new LinkedList<T>();

		T pivot = list.removeFirst();

		Iterator<T> iterator = list.listIterator(0);

		while (iterator.hasNext()) {
			T item = iterator.next();
			if (pivot.compareTo(item) < 0) {
				right.add(item);
				iterator.remove();
			}
		}

		iterator = null;

		quickSortLinkedListInPlace(list);
		quickSortLinkedListInPlace(right);	

		list.add(pivot);
		list.addAll(right);
	}
}