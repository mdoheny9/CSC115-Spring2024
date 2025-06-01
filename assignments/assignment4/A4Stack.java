public class A4Stack<T> implements Stack<T> {
	
	private A4Node<T> head;
	// Do NOT add any other fields to this class.
	// You should be able to implement the Stack 
	// interface with just a head field.

	public A4Stack() {
		head = null;
	}
	
	public void push(T value) {
		A4Node<T> n = new A4Node<T>(value);
		if (head == null) {
			head = n;
		} else {
			head.setNext(n);
		}
	}
	
	public T pop() {
		if (head == null) {
			return null;
		} else {
			A4Node<T> cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}
			A4Node<T> result = cur;
			cur = null;
			return result.getData();
		}
		
	}
	
	public void popAll() {
		head = null;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public T peek() {
		if (head == null) {
			return null;
		} else {
			A4Node<T> cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}
			return cur.getData();
	}
}
	
	// Implemented for you for debugging purposes
	public String toString() {
		String result = "{";
		String separator = "";
		
		A4Node<T> cur = head;
		while (cur != null) {
			result += separator + cur.getData().toString();
			separator = ", ";
			cur = cur.next;
		}
	
		result += "}";
		return result;
	}
}