public class Fundraiser {
	private String name;
	private AuctionItem[] items;
	
	public Fundraiser() {
		this.name = null;
		this.items = null;
	}
	
	public Fundraiser(String name, AuctionItem[] items) {
		this.name = name;
		this.items = items;
	}
	
	public String getName() {
		return name;
	}
	
	public AuctionItem[] getItems() {
		return items;
	}
	
	public String toString() {
		if (items == null || items.length == 0) {
			return "Fundraiser without any items";
		}
		String s = name + "\nauction items:\n";
		for (int i = 0; i < items.length; i++) {
			s += items[i].toString();
		}
		return s;
	}
	
	/*
	 * Purpose: get the money raised, which will be the 
	 *          sum of all auction items that are sold
	 * Parameters: none
	 * Returns: int - the total money this fundraiser raises
	 */
	public int moneyRaised() {
		if (items == null) {
			return 0;
		} else {
			int sum = 0;
			for (int i = 0; i < items.length; i++) {
				sum += items[i].getHighestBid();
			}
			return sum;
		}
	}
	
	/*
	 * Purpose: get the total money spent at this fundraiser
	 *          by those with the given name
	 * Parameters: String name - the name to search for
	 * Returns: int - the total money spent by name
	 */
	public int moneySpent(String name) {
		if ((items == null) || (items.length == 0)) {
			return 0;
		} else {
			int sum = 0;
			for (int i = 0; i < items.length; i++) {
				if (items[i].getBidderName().equals(name)) {
					sum += items[i].getHighestBid();
				}
			}
			return sum;
		}
		
	}
	
	/* 
	 * Purpose: get the most expensive auction item at this fundraiser
	 * Parameters: none
	 * Returns: AuctionItem - the most expensive item
	 * Preconditions: items is not null, and items.length > 0
	 */
	public AuctionItem mostExpensive() {
		int result = 0;
		AuctionItem highestExpense = null;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getHighestBid() > result) {
				result = items[i].getHighestBid();
				highestExpense = items[i];
			}
		}
		return highestExpense;
	}
	
	/* 
	 * Purpose: adds the new item to the items sold at this fundraiser
	 * Parameters: AuctionItem newItem - the item to add to the fundraiser
	 * Returns: void - nothing
	 */
	public void addToFundraiser(AuctionItem newItem) {
		if ((items == null) || (items.length == 0)) {
			AuctionItem[] result = {newItem};
			items = result;
		} else {
			AuctionItem[] newItems = new AuctionItem[items.length + 1];
			for (int i = 0; i < items.length; i++) {
				newItems[i] = items[i];
			}
			newItems[items.length] = newItem;
			items = newItems;
		}
		
	}
	
}