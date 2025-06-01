public interface List {

	/* 
	 * Purpose: add c to the back of the list
	 * Parameters: Competitor c - the competitor to add
	 * Returns: nothing
	 * Precondition: c is not null
	 */
	public void add(Competitor c);
		
	/* 
	 * Purpose: get the current size of the list
	 * Parameters: none
	 * Returns: int - number of elements in list
	 */
	public int size(); 
			
	/* 
	 * Purpose: gets the competitor at the given index in the list
	 * Parameters: int index - the index of the competitor to access
	 * Returns: Competitor - the competitor at the given index
	 * Precondition: 0 <= index < size()
	 */
	public Competitor get(int index);
	
	/*
	 * Purpose: get the index of c in this list
	 * Parameters: Competitor c - the competitor to find
	 * Returns: int - index of c, or -1 if c is not in this list
	 */
	public int find(Competitor c);
	
}