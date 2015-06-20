package adt;

class ListTests {

	public static void main(String... args) {
		Node<String> list = new Node<>("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");

		System.out.println("Original: " + list);
		System.out.println("List size: " + list.size());

		int i = 5;
		System.out.printf("%dth from list end is %s\n", i, list.getFromEnd(i).data);

		int k = 5;
		list = list.removeFromEnd(k);
		System.out.println("Remove " + k + "th element from the end using 'Runner' technique: " + list);

		int l = 4;
		list = list.removeFromEndRecurse(l);
		System.out.println("Remove " + l + "th element from the end using recursion: " + list);

		Node.removeFromMiddle(list.get(2));
		System.out.println("List with second node removed is " + list);

		Node<Integer> listToPartition = new Node<>(10);
		listToPartition.add(2);
		listToPartition.add(13);
		listToPartition.add(5);
		listToPartition.add(4);
		listToPartition.add(16);
		listToPartition.add(6);
		System.out.println("List to partition: " + listToPartition);
		Integer partitionPoint = 7;
		System.out.println("List partitioned around " + partitionPoint + ": " + listToPartition.partition(partitionPoint));


		Node<Integer> a = new Node<>(7);
		a.add(1);
		a.add(6);
		Node<Integer> b = new Node<>(5);
		b.add(9);
		b.add(2);
		System.out.println(a + " + " + b + " = " + addNumbersBackwardOrder(a, b));

		Node<Integer> c = new Node<>(6);
		c.add(1);
		c.add(7);
		Node<Integer> d = new Node<>(2);
		d.add(9);
		d.add(5);
		System.out.println(c + " + " + d + " = " + addNumbersForwardOrder(c, d));

		Node<Integer> e = new Node<>(3);
		e.add(4);
		e.add(5);
		e.add(7);
		e.add(8);
		e.add(9);
		System.out.println("List contains loop (should be false): " + hasLoop(e));
		Node<Integer> loopNode = new Node<>(10);

		Node<Integer> f = e.get(2);
		loopNode.next = f.next;
		f.next = loopNode;

		e.get(6).next = loopNode;

		System.out.println("List contains loop (should be true): " + hasLoop(e));
		System.out.println("Loop start data should be 10: " + loopStart(e).data);



	}

	/*
	 * You have two numbers represented by a linked list, where each node contains a single digit. 
	 * The digits are stored in reverse order, such that the Ts digit is at the head of the list. 
	 * Write a function that adds the two numbers and returns the sum as a linked list.
	 * 
	 * EXAMPLE
	 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
	 * Output: 2 -> 1 -> 9.That is, 912.
	 *
	 * FOLLOW UP
	 * Suppose the digits are stored in forward order. Repeat the above problem. 
	 * 
	 * EXAMPLE
	 * Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
	 * Output: 9 -> 1 -> 2.That is, 912.
	 */
	static Node<Integer> addNumbersBackwardOrder(Node<Integer> a, Node<Integer> b) {
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		boolean carry = false;
		Node<Integer> sumHead = null;
		Node<Integer> sumTail = null;
		while (a != null && b != null) {
			int digit = a.data + b.data + (carry ? 1 : 0); 
			carry = digit > 9;
			if (carry) {
				digit %= 10;
			}
			if (sumHead == null) {
				sumHead = sumTail = new Node<>(digit);
			} else {
				sumTail.next = new Node<>(digit);
				sumTail = sumTail.next;
			}
			a = a.next;
			b = b.next;
		}

		if (a != null || b != null) {
			sumTail.next = a == null ? b : a;
			sumTail = sumTail.next;
			if (carry) {
				while (sumTail != null) {
					sumTail.data++;
					if (sumTail.data > 9) {
						sumTail.data %= 10;
						sumTail = sumTail.next;
					} else {
						carry = false;
						break;
					}
				}
			}
		}

		if (carry) {
			sumTail.next = new Node<>(1);
		}

		return sumHead;
	}

	static Node<Integer> addNumbersForwardOrder(Node<Integer> a, Node<Integer> b) {
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		boolean carry = false;
		Node<Integer> sumHead = null;
		Node<Integer> sumTail = null;
		while (a != null && b != null) {
			int digit = a.data + b.data + (carry ? 1 : 0); 
			carry = digit > 9;
			if (carry) {
				digit %= 10;
			}
			if (sumHead == null) {
				if (carry) {
					sumHead = sumTail = new Node<>(1);
					sumTail.next = new Node<>(digit);
					sumTail = sumTail.next;
				} else {
					sumHead = sumTail = new Node<>(digit);
				}
			} else {
				sumTail.next = new Node<>(digit);
				sumTail = sumTail.next;
			}
			a = a.next;
			b = b.next;
		}
		if (a == null) {
			sumTail.next = b;
		} else if (b == null) {
			sumTail.next = a;
		}

		return sumHead;
	}

	/**
	 * Uses fast / slow runners technique
	 * 
	 * Time complexity worst case: O(n), best case: O(k) where k is the number of elements before the loop and k is less than n by definition.
	 * Space complexity 1
	 *
	 * @return True if this list contains a loop, false otherwise
	 */
	public static <T extends Comparable<T>> boolean hasLoop(Node<T> list) {
		Node<T> slow = list;
		Node<T> fast = list;

		// find the collision point
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Uses fast / slow runners technique
	 * 
	 * Time complexity worst case: O(n), best case: O(k) where k is the number of elements before the loop and k is less than n by definition.
	 * Space complexity 1
	 *
	 * @param head List head
	 * @return Node which is a loop start
	 */
	public static <T extends Comparable<T>> Node<T> loopStart(Node<T> head) {
		Node<T> slow = head;
		Node<T> fast = head;

		// find the collision point
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		// No loop
		if (fast == null || fast.next == null) {
			return null;
		}
		
		slow = head;

		// find the loop start
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}

}