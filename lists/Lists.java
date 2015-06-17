package lists;

import java.util.*;

class Lists {

	public static void main(String... args) {
		LinkedList<Object> list = new LinkedList<>(Arrays.asList(1, 1, 1, 2, 3, 3));
		System.out.println("Original: " + list);
		dedup(list);
		System.out.println("Deduped using hash table set: " + list);

		LinkedList<Object> list2 = new LinkedList<>(Arrays.asList(1, 1, 1, 2, 3, 3));
		System.out.println("Original: " + list2);
		dedup(list2);
		System.out.println("Deduped using low level hash table: " + list2);

		LinkedList<Object> list1 = new LinkedList<>(Arrays.asList(1, 1, 1, 2, 3, 3));
		System.out.println("Original: " + list1);
		dedup(list1);
		System.out.println("Deduped using double iteration: " + list1);
	}

	/**
	 * Dedups an unsorted list using hash table set.
	 * 
	 * Time complexity O(n)
	 * Space complexity O(n)
	 */
	public static void dedup1(LinkedList<Object> list) {
		ArrayList<LinkedList<Object>> hashTable = new ArrayList<>(list.size());
		ListIterator i = list.listIterator();
		while(i.hasNext()) {
			Object item = i.next();
			int bucket = item.hashCode() % list.size();
			LinkedList<Object> hashedList = hashTable.get(bucket);
			if (hashedList == null) {
				hashTable.set(bucket, new LinkedList<>());
				hashTable.get(bucket).add(item);	
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
	 * Dedups an unsorted list using hash table set.
	 * 
	 * Time complexity O(n)
	 * Space complexity O(n)
	 */
	public static void dedup(LinkedList<Object> list) {
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
	 * Dedups a unsorted list using double iteration.
	 *
	 * Time complexity O(n^2)
	 * Space complexity O(1)
	 */
	public static void dedupSavingMemory(LinkedList<Object> list) {
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