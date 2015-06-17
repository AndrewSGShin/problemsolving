package lists;

/*
 * Singly linked list
 */
class Node<T extends Comparable<T>> {

	T data;

	Node<T> next = null;

	public Node(T data) {
		this.data = data;
	}

	/*
	 * Appends to the end of the list. O(n)
	 */
	public void add(T data) {
		Node<T> last = this;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new Node<T>(data);
	}

	/*
	 * Indexed access. O(n)
	 */
	public Node<T> get(Integer index) {
		Node<T> result = this;
		while (index > 0) {
			result = result.next;
			if (result == null) {
				throw new IndexOutOfBoundsException();
			}
			index--;
		}
		return result;
	}

	/**
	 * Time complexity O(n)
	 * Space complexity O(1)
	 */
	public Node<T> getFromEnd(int index) {
		Node<T> runner = this;
		for (int i = 0; i < index; i++) {
			runner = runner.next;
			if (runner == null) {
				return null;
			}
		}

		Node<T> result = this;
		while (runner.next != null) {
			runner = runner.next;
			result = result.next;
		}

		return result;
	}

	/**
	 * Time complexity O(n)
	 *
	 * @param list
	 * @param index from the end (1-based)
	 * @return list with k-th element (counted from the end) removed
	 */
	public Node<T> removeFromEnd(int index) {
		Node<T> previous = getFromEnd(index + 1);
		if (previous == null) {
			return this.next;
		} else {
			previous.next = previous.next.next;
			return this;
		}
	} 

	/**
	 * Space complexity O(n)
	 */
	public Node<T> removeFromEndRecurse(int index) {
		int indexFromEnd = removeFromEndRecurseIteration(this, index);
		if (index == indexFromEnd) {
			return this.next;
		} else {
			return this;
		}
	}

	private int removeFromEndRecurseIteration(Node<T> current, int deleteIndex) {
		if (current.next == null) {
			// we are at the last element
			return 0;
		} else {
			int indexFromEnd = removeFromEndRecurseIteration(current.next, deleteIndex) + 1;
			if (indexFromEnd == deleteIndex + 1) {
				current.next = current.next.next;
			}
			return indexFromEnd;
		}
	}

	/* Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
	 *
	 * EXAMPLE
	 * Input: the node c from the linked list a->b->c->d->e
	 * Result: nothing isreturned, but the new linked list looks like a->b->d->e
	 */
	public static <T extends Comparable<T>> boolean removeFromMiddle(Node<T> node) {
		Node<T> next = node.next;
		if (next == null) {
			return false;
		}
		node.data = next.data;
		node.next = next.next;
		return true;
	}

	public int size() {
		int size = 1;
		Node<T> tail = this;
		while (tail.next != null) {
			size++;
			tail = tail.next;
		}
		return size;
	}

	/*
	 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
	 */
	public Node<T> partition(T value) {
		Node<T> node = this;
		
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

	/*
	 * O(n)
	 */
	@Override
	public String toString() {
		StringBuilder acc = new StringBuilder();
		acc.append("[").append(data);
		Node<T> last = this;
		while (last.next != null) {
			last = last.next;
			acc.append(", ").append(last.data);
		}
		acc.append("]");
		return acc.toString();
	}
}