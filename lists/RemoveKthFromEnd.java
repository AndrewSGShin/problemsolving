package lists;

class RemoveKthFromEnd {

	public static void main(String... args) {
		Node list = new Node("1");
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

	}

	/**
	 * Time complexity O(n)
	 */
	static Node removeKthFromEnd(Node list, int k) {
		int size = size(list);
		if (k < 0 || k > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		int previousToKth = size - 2 - k;
		if (previousToKth < 0) {
			return list.next;
		}
		
		Node prev = list;
		for (int i = previousToKth; i > 0; i--) {
			prev = prev.next;
		}
		prev.next = prev.next.next;
		return list;
	} 

	static int size(Node list) {
		int size = 1;
		Node tail = list;
		while (tail.next != null) {
			size++;
			tail = tail.next;
		}
		return size;
	}

	static Node removeKthFromEndRecurse(Node list, int k) {
		int indexFromEnd = removeKthFromEndRecurseIteration(list, k);
		if (k == indexFromEnd) {
			return list.next;
		} else {
			return list;
		}
	}

	static int removeKthFromEndRecurseIteration(Node current, int deleteIndex) {
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
	static Node getKthFromEnd(Node list, int k) {
		if (list == null) {
			throw new NullPointerException();
		}
		Node p1 = list;
		Node p2 = list;
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
}