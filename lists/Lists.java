package lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.HashSet;
import java.util.Set;

class Lists {

	public static void main(String... args) {
		LinkedList<Object> list = new LinkedList<>(Arrays.asList(1, 1, 1));
		System.out.println("Original: " + list);
		removeDupsInPlace(list);
		System.out.println("With duplicates removed: " + list);
	}

	// Write code to remove duplicates from an unsorted linked list.
	// How would you solve this problem if a temporary buffer is not allowed?
	@SuppressWarnings("unchecked")
	public static void removeDuplicates(LinkedList<Object> list) {
		LinkedList<Object>[] hashTable = (LinkedList<Object>[]) new LinkedList[list.size()];
		ListIterator i = list.listIterator();
		while(i.hasNext()) {
			Object item = i.next();
			int bucket = item.hashCode() % list.size();
			LinkedList hashedList = hashTable[bucket];
			if (hashedList == null) {
				hashTable[bucket] = new LinkedList();
				hashTable[bucket].add(item);	
			} else {
				boolean contains = false;
				for (Object hashed : hashedList) {
					if (hashed.equals(item)) {
						i.remove();
						contains = true;
					}
				}

				if (!contains) {
					hashedList.add(item);
				}
			}
		}
	}

	/**
	 * Time complexity O(n)
	 * Space complexity O(n)
	 */
	public static void removeDuplicates2(LinkedList<Object> list) {
		Set<Object> met = new HashSet<Object>(list.size());
		ListIterator i = list.listIterator();
		while(i.hasNext()) {
			Object item = i.next();
			if (met.contains(item)) {
				i.remove();
			} else {
				met.add(item);
			}
		}
	}

	/**
	 * Time complexity O(n^2)
	 * Space complexity O(1)
	 */
	public static void removeDupsInPlace(LinkedList<Object> list) {
		for (int i = 0; i < list.size(); i++) {
			ListIterator it = list.listIterator(i);
			Object item = it.next();
		    while(it.hasNext()) {
				Object nextItem = it.next();
				if (nextItem.equals(item)) {
					it.remove();
				}
			}
		}
	}


}