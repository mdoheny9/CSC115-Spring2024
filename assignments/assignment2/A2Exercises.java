public class A2Exercises {
	
	/*
	 * Purpose: get the total money raised across all fundraisers
	 *          in the given array
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: int: total money raised across all fundraisers
	 * Precondition: the array is not null
	 */	
	public static int totalMoneyRaised(Fundraiser[] array) {
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i].moneyRaised();
		}
		return total;
	}
	
	/*
	 * Purpose: get the total money spent on winning auctions 
	 *          by people with the provided name
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 *             String name - the name to search for
	 * Returns: int: total money raised across all fundraisers
	 * Precondition: the array and name are not null
	 */	
	public static  int totalSpent(Fundraiser[] array, String name) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i].moneySpent(name);
		}
		return sum;
	}

	/*
	 * Purpose: create a new array of AuctionItems that contains
	 *          only the most expensive item from each fundraiser
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: AuctionItem[]: the array of most expensive items
	 * Precondition: the array is not null
	 */	
	public static AuctionItem[] mostExpensiveItems(Fundraiser[] array) {
		AuctionItem[] newArray = new AuctionItem[array.length];

		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i].mostExpensive();
		}
		return newArray;
	}
	
	/*
	 * Purpose: calculate and return the average price of the most
	 *          expensive items from each fundraiser in the array
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: double - the average price of the most expensive items
	 * Precondition: the array is not null
	 */	
	public static double averageOfMostExpensive(Fundraiser[] array) {
		if ((array.length == 0) || (array == null)){
			return 0;
		} else {
			double total = 0;
			AuctionItem[] mostExpensive = mostExpensiveItems(array);
	
			for (int i = 0; i < mostExpensive.length; i++) {
				total += mostExpensive[i].getHighestBid();
			}
			return (total/mostExpensive.length);
		}
		
	}
}