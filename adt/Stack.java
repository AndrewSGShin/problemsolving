package adt;

class Stack<T extends Comparable<T>> {
	Node<T> top;

	T pop() {
		if (top != null) {
			T item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	void push(T item) {
		Node<T> t = new Node<>(item);
		t.next = top;
		top = t;
	}

	T peek() {
		return top == null ? null : top.data;
	}
}