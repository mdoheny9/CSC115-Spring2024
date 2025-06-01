// Name: Megan Doheny
// Student number: v01038301

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node n = new A3Node(s);
		if (head != null) {
			n.next = head;
			head.prev = n;
		} else {
			tail = n;
		}
		head = n;
		length++;
	}

	public void addBack(String s) {
		A3Node n = new A3Node(s);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			A3Node cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = n;
			n.prev = cur;
			tail = n;
		}
		length++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		head = head.next;
	}
	
	public void removeBack() {
		A3Node cur = head;
		while (cur.next.next != null) {
			cur = cur.next;
		}
		cur.next = null;
	}
	
	
	
	//////////////////
	/* PART 2 BELOW */
	//////////////////
	
	public void removeMiddle() {
		// TODO: implement this
		A3Node cur = head;
		if (cur == null || length == 1 || length == 2) {
			head = null;
			tail = null;
			length = 0;

		// even length cases
		} else if (length % 2 == 0) {
				int pos = (length/2) - 1;
				for (int i = 0; i < pos - 1; i++) {
					cur = cur.next;
				}
				cur.next = cur.next.next.next;
				cur.next.prev = cur;
				length -= 2;

		// odd length cases
		} else {
			int pos = (length/2);
			for (int i = 0; i < pos - 1; i++) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
			cur.next.prev = cur;
			length--;
		}	
	}

	
	
	public void interleave(A3LinkedList other) {
		// TODO: implement this
		A3Node cur1 = this.head;
		A3Node cur2 = other.head;
			
		A3Node next1;
		A3Node next2;

		if ((cur1 != null) && (cur2 != null)) {

			while (cur1.next != null) {
				next1 = cur1.next;
				next2 = cur2.next;

				cur1.next = next2;
				cur2.next = next1;

				next1.setPrev(cur2);
				next2.setPrev(cur1);

				cur1 = cur1.next;
				cur2 = cur2.next;
			}
		}
		tail = cur1;
		other.tail = cur2;
	}
	
	
	
	////////////////////////////////////////
	/* METHODS BELOW TO HELP WITH TESTING */
	////////////////////////////////////////
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	