package lists;

class RemoveKthFromEnd {

	public static void main(String... args) {
		Node<String> list = new Node<>("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");

		System.out.println("Original: " + list);
		System.out.println("List size: " + size(list));

		int i = 5;
		System.out.printf("%dth from list end is %s\n", i, getKthFromEnd(list, i).data);

		int k = 5;
		list = removeKthFromEnd(list, k);
		System.out.println("List with " + k + "th element (0-based) from the end removed: " + list);

		int l = 4;
		list = removeKthFromEndRecurse(list, l);
		System.out.println("List with " + l + "th element (0-based) from the end removed: " + list);

		Node<String> node = list.get(2);
		System.out.println("Second node is " + node.data);

		removeFromMiddle(node);

		System.out.println("List with node removed is " + list);

		Node<Integer> listToPartition = new Node<>(10);
		listToPartition.add(2);
		listToPartition.add(13);
		listToPartition.add(5);
		listToPartition.add(4);
		listToPartition.add(16);
		listToPartition.add(6);
		System.out.println("List to partition: " + listToPartition);
		Integer partitionPoint = 7;
		System.out.println("List partitioned around " + partitionPoint + ": " + partition(listToPartition, partitionPoint));


	}

	/**
	 * Time complexity O(n)
	 */
	static <T extends Comparable<T>> Node<T> removeKthFromEnd(Node<T> list, int k) {
		int size = size(list);
		if (k < 0 || k > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		int previousToKth = size - 2 - k;
		if (previousToKth < 0) {
			return list.next;
		}
		
		Node<T> prev = list;
		for (int i = previousToKth; i > 0; i--) {
			prev = prev.next;
		}
		prev.next = prev.next.next;
		return list;
	} 

	static <T extends Comparable<T>> int size(Node<T> list) {
		int size = 1;
		Node<T> tail = list;
		while (tail.next != null) {
			size++;
			tail = tail.next;
		}
		return size;
	}

	static <T extends Comparable<T>> Node<T> removeKthFromEndRecurse(Node<T> list, int k) {
		int indexFromEnd = removeKthFromEndRecurseIteration(list, k);
		if (k == indexFromEnd) {
			return list.next;
		} else {
			return list;
		}
	}

	static <T extends Comparable<T>> int removeKthFromEndRecurseIteration(Node<T> current, int deleteIndex) {
		if (current.next == null) {
			// we are at the last element
			return 0;
		} else {
			int indexFromEnd = removeKthFromEndRecurseIteration(current.next, deleteIndex) + 1;
			if (indexFromEnd == deleteIndex + 1) {
				current.next = current.next.next;
			}
			return indexFromEnd;
		}
	}

	/**
	 * Time complexity O(n)
	 * Space complexity O(1)
	 */
	static <T extends Comparable<T>> Node<T> getKthFromEnd(Node<T> list, int k) {
		if (list == null) {
			throw new NullPointerException();
		}
		Node<T> p1 = list;
		Node<T> p2 = list;
		for (int i = k; i > 0; i--) {
			p2 = p2.next;
			if (p2 == null) {
				throw new IndexOutOfBoundsException();
			}
		}

		while (p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}

		return p1;
	}
	
	/* Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
	 *
	 * EXAMPLE
	 * Input: the node c from the linked list a->b->c->d->e
	 * Result: nothing isreturned, but the new linked list looks like a->b->d->e
	 */
	static <T extends Comparable<T>> boolean removeFromMiddle(Node<T> node) {
		Node<T> next = node.next;
		if (next == null) {
			return false;
		}
		node.data = next.data;
		node.next = next.next;
		return true;
	}

	/*
	 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
	 */
	static <T extends Comparable<T>> Node<T> partition(Node<T> list, T value) {
		Node<T> node = list;
		
		Node<T> greaterHead = null;
		Node<T> greaterTail = null;
		Node<T> lessHead = null;
		Node<T> lessTail = null;

		while (node != null) {
			Node<T> next = node.next;
			node.next = null;
			if (node.data.compareTo(value) < 0) {
				if (lessTail == null) {
					lessHead = lessTail = node;
				} else {
					lessTail.next = node;
					lessTail = lessTail.next;
				}
			} else {
				if (greaterTail == null) {
					greaterHead = greaterTail = node;
				} else {
					greaterTail.next = node;
					greaterTail = greaterTail.next;
				}
			}
			node = next;
		}

		if (lessTail == null) {
			return greaterHead;
		}

		lessTail.next = greaterHead;
		return lessHead;
	}
}