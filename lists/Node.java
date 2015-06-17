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

	public void add(T data) {
		Node<T> last = this;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new Node<T>(data);
	}

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