public class AuctionItem {
	private String description;
	private int highestBid;
	private String bidderName;
	
	public AuctionItem(String description, int highestBid, String bidderName) {
		this.description = description;
		this.highestBid = highestBid;
		this.bidderName = bidderName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getHighestBid() {
		return highestBid;
	}
	
	public String getBidderName() {
		return bidderName;
	}
	
	public String toString() {
		String bidAmount = "bid $"+highestBid;
		String bidder = "by "+bidderName;
		return description+": "+bidAmount+" "+bidder+"\n";
	}
	
	public boolean equals(AuctionItem other) {
		return this.description.equals(other.description)
			&& this.highestBid == other.highestBid
				&& this.bidderName.equals(other.bidderName);
	}
	
	/*
	 * Purpose: determine whether the bid amount results in 
	 *          a new highest bid for this auction item
	 *          if so, the highestBid and bidderName are updated
	 * Parameters: int amount - the amount of the new bid
	 *             String name - name of person making the bid
	 * Returns: boolean - true if the bid amount is higher than
	 *                    the current highest, false otherwise
	 */
	public boolean makeBid(int amount, String name) {
		boolean newHighest = false;
		if (amount > highestBid) {
			this.highestBid = amount;
			this.bidderName = name;
			newHighest = true;
		}
		return newHighest;
	}
}