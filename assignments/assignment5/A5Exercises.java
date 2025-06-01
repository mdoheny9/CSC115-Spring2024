import org.w3c.dom.Node;

public class A5Exercises {

	/*
	 * Purpose: change all occurrences of x to y in the given list
	 * Parameters: List<T> theList - the list to search through
	 *			   T x - the value to change
	 *			   T y = the value to change all x's to
	 * Returns: void - nothing
	 */
	private static <T> List xToYRec(List<T> theList, int i, T x, T y) {
		if (theList.isEmpty() || i >= theList.size()) {
			return null;
		} else {
			if (theList.get(i).equals(x)) {
				theList.change(i, y);
			}
			return xToYRec(theList, i+1, x, y);
		}
			
	}

	public static<T> void changeXToY(List<T> theList, T x, T y) {
		theList = xToYRec(theList, 0, x, y);
	}
	
	/*
	 * Purpose: count the total number of odd values in this list
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the total number of odd values found
	 */

	private static int countOddRec(List<Integer> theList, int i) {
		if(theList.isEmpty() || i >= theList.size()) {
			return 0;
		} else {
			if (theList.get(i) % 2 != 0) {
				return 1 + countOddRec(theList, i+1);
			} else {
				return countOddRec(theList, i+1);
			}
		}
	}

	public static int countOdd(List<Integer> theList) {
		return countOddRec(theList, 0);
	}
	

	/*
	 * Purpose: get the largest sequence of odd values found in a row
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the largest sequence of odd values found in a row
	 */
	private static int countOddInARowRec(List<Integer> theList, int i, int curInARow, int mostInARow) {
		if (theList.isEmpty() || i >= theList.size()) {
			return mostInARow;
		} else {
			if (theList.get(i) % 2 != 0) {
				if (curInARow+1 > mostInARow) {
					return countOddInARowRec(theList, i+1, curInARow+1, mostInARow+1);
				} else {
					return countOddInARowRec(theList, i+1, curInARow+1, mostInARow);
				}
			} else {
				return countOddInARowRec(theList, i+1, 0, mostInARow);
			}
		}
	}

	public static int countMostOddInARow(List<Integer> theList) {
		return countOddInARowRec(theList, 0, 0, 0);
	}
	
	
	/*
	 * Purpose: count the elements found in between the first two x's
	 * Parameters: List<Integer> theList - the list of Integers
	 *             int x - the values to search for
	 * Returns: int - the number of values in the list found 
	 *                between the first 2 occurrences if x,
	 *                or -1 if there are not 2 x's in the list.
	 */
	private static int betweenXRec(List<Integer> theList, int x, int i, int count, int tracker) {
		if (theList.isEmpty() || (i >= theList.size() && count < 2)) {
			// if there are not 2 x's in list
			return -(tracker + 1);
		} else if (i >= theList.size()) {
			return 0;
		} else if (theList.get(i) != x) {
			// cur index is not x
			if (count == 0) {
				// we have not yet reached an x
				return betweenXRec(theList, x, i+1, count, tracker);
			
			} else if (count == 1) {
				// we have reached x and start counting 
				return 1 + betweenXRec(theList, x, i+1, count, tracker+1);

			} else {
				// count == 2, so stop the loop
				return 0;
			}
		} else {
			// cur index is x 
			count += 1;
			return betweenXRec(theList, x, i+1, count, tracker);
		}
	}

	public static int countBetweenX(List<Integer> theList, int x) {
		return betweenXRec(theList, x, 0, 0, 0);
	}
	
}