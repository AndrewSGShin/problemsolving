package lists;

/*
 * Singly linked list
 */
class Node {

	Object data;

	Node next = null;

	public Node(Object data) {
		this.data = data;
	}

	public void add(Object data) {
		Node last = this;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new Node(data);
	}

	public Node get(Integer index) {
		Node result = this;
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
		Node last = this;
		while (last.next != null) {
			last = last.next;
			acc.append(", ").append(last.data);
		}
		acc.append("]");
		return acc.toString();
	}
}