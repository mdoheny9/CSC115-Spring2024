/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		// TODO: implement this
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
		storage = new Comparable[DEFAULT_SIZE];
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		// TODO: implement this
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
		storage = new Comparable[size];
		currentSize = 0;
	}

	public void insert (Comparable element) throws HeapFullException {
		// TODO: implement this
		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
		if (currentSize >= storage.length) {
			throw new HeapFullException();
		}
		currentSize++;
		storage[currentSize-1] = element;
		bubbleUp(currentSize-1);
    }
	
	public void bubbleUp(int index) {
		// TODO: implement this
		int parentIndex = (int)Math.floor((index-1)/2);
		if (index > 1 && storage[index].compareTo(storage[parentIndex]) < 0) {

			Comparable t = storage[index];
			storage[index] = storage[parentIndex];
			storage[parentIndex] = t;
			bubbleUp(parentIndex);
			}
	}
	
			
	public Comparable removeMin() throws HeapEmptyException {
		// TODO: implement this
		if (this.isEmpty()) {
			throw new HeapEmptyException("tree is empty");
		}
		Comparable ogRoot = storage[0];
		storage[0] = storage[currentSize - 1];

		storage[currentSize - 1] = null;

		currentSize--;
		bubbleDown(0);
		return ogRoot;
	}
	
	private void bubbleDown(int index) {
		// TODO: implement this
		int childMin;
		int leftChildIndex = (2 * index + 1);
		int rightChildIndex = (2 * index + 2);

		if (leftChildIndex >= currentSize ) {
			return;
		} else if (rightChildIndex >= currentSize) {
			childMin = leftChildIndex;
		} else {
			if (storage[leftChildIndex].compareTo(storage[rightChildIndex]) < 0) {
				childMin = leftChildIndex;
			} else {
				childMin = rightChildIndex;
			}
		}

		if (storage[index].compareTo(storage[childMin]) > 0) {

			Comparable t = storage[index];
			storage[index] = storage[childMin];
			storage[childMin] = t;
			bubbleDown(childMin);
		}

	}

	public boolean isEmpty(){
		// TODO: implement this
		
		return (currentSize == 0);
	}
	
	public boolean isFull() {
		// TODO: implement this
		
		return (currentSize == storage.length); 
	}
	
	public int size () {
		// TODO: implement this
		
		return currentSize; 
	}

	public String toString() {
		String s = "";
		String sep = "";
		// This implementation of toString assumes you 
		// are using a 1-based approach. Update the initial
		// and final value for i if using a 0-based
		for(int i=1; i<=currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}
}
