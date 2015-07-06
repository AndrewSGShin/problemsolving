package adt;

class Queue<T extends Comparable<T>> {
	Node<T> first;
	Node<T> last;

	void enqueue(T item) {
		if (first == null) {
			first = last = new Node<>(item);
		} else {
			last.next = new Node<>(item);
			last = last.next;
		}
	}

	T dequeue() {
		if (first != null) {
			T item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}
}