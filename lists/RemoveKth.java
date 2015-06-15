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

		int k = 5;
		list = removeKthFromEnd(list, k);

		System.out.println("List with " + k + "th element (0-based) from the end removed: " + list);
	}

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
}