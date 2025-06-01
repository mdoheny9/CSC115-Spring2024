public class QueueRefBased implements Queue {

	private QueueNode front;
	private QueueNode back;
	// no numElements for this implementation

	public QueueRefBased() {
		front = null;
		back = null;
	}

	public int size() {
		int count = 0;	
		if (front != null) {
			count++;
			QueueNode cur = front;
			while (cur.next != null) {
				cur = cur.next;
				count++;
			}
		}	
		return count;	
	}

	public boolean isEmpty() {
		return (front == null);
	}

	public void enqueue (int value) {
		QueueNode n = new QueueNode(value);
		if (front == null) {
			front = n;
			back = n;
		} else if (back != null) {
			back.setNext(n);
			back = n;
		}
	}

	public int dequeue() {
		if (size() == 0) {
			return -1;
		} else {
			QueueNode var = front;
			front = front.getNext();
			return var.getValue();
		}
		// if (size() == 1) {
		// 	QueueNode var = front;
		// 	front = var;
		// 	back = var;
		// 	return var.getValue();
		// } if (size() > 1) {
		// 	QueueNode var = front;
		// 	front = front.getNext();
		// 	return var.getValue();
		// } else {
		// 	return 0;
		// }
		
	}

	public int peek()  {
		return front.getValue();
	}

	public void makeEmpty() {
		front = null;
	}
}
