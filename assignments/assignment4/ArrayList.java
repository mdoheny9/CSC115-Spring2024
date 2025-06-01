public class ArrayList implements List {

	private Competitor[] storage;
	private int numElements;
	
	public ArrayList(int size) {
		this.storage = new Competitor[size];
		this.numElements = 0;
	}
	
	public ArrayList(Competitor[] array) {
		this.storage = array;
		numElements = array.length;
	}
	
	public void expandAndCopy() {
		Competitor[] newStorage = new Competitor[storage.length*2];
		for (int i = 0; i < storage.length; i++) {
			newStorage[i] = storage[i];
		}
		this.storage = newStorage;
	}
	
	public void add(Competitor c) {
		while (numElements >= storage.length) {
			expandAndCopy();
		}
		storage[numElements++] = c;
	}
		
	public int size() {
		return this.numElements;
	}
			
	public Competitor get(int index) {
		return storage[index];
	}

	public int find(Competitor c) {
		int index = -1;
		int cur = 0;
		while (cur < numElements && index == -1) {
			if (storage[cur].equals(c)) {
				index = cur;
			}
			cur++;
		}
		return index;
	}
	
}