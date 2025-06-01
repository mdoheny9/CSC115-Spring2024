public class LinkedSongList {
	// DO NOT ADD ANY MORE FIELDS OR METHODS
	private SongNode head;
	
	public LinkedSongList() {
		head = null;
	}

	public void addFront (Song s) {
		SongNode n = new SongNode(s);
		n.next = head;
		head = n;
	}

	public void addBack (Song s){
		SongNode n = new SongNode(s);
		if (head == null) {
			head = n;
		} else {
			addBackRec(head, n);
		}
	}
	
	private void addBackRec(SongNode cur, SongNode n) {
		if (cur.next == null) {
			cur.next = n;
		} else {
			addBackRec(cur.next, n);
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Song get (int position) {
		return getRec(head, 0, position);
	}
	
	private Song getRec(SongNode cur, int i, int position) {
		if (i == position) {
			return cur.getData();
		} else {
			return getRec(cur.next, i+1, position);
		}
	}

	/* Purpose: create a string representation of list
	 * Parameters: nothing	 
	 * Returns: String - the string representation of the list
	 */
	public String toString() {
		if (head == null) {
			return "{}";
		} else {
			return "{" + toStringRec(head) + "}";
		}
	}
	
	private String toStringRec(SongNode cur) {
		if (cur == null) {
			return "";
		} else if (cur.next == null) {
			return cur.getData().toString();
		} else {
			return cur.getData().toString() + ", " + toStringRec(cur.next);
		}
	}

	/*
	 * Purpose: Insert all elements from array into this linked list
	 * Parameters: Song[] array - the elements to add to this list
	 * Returns void - nothing
	 */
	public void buildFromArray(Song[] array) {
		buildFromArrayRec(array, array.length-1);
	}
	
	private void buildFromArrayRec(Song[] array, int i) {
		if (i < 0) {
			return;
		} else {
			addFront(array[i]);
			buildFromArrayRec(array, i-1);
		}
	}
	

	/*
	 * Purpose: gets the total number of songs in this list
	 * Parameters: none
	 * Returns: int - the number of songs in this list
	 */
	private int countSongsRecursive(SongNode cur) {
		if (cur == null) {
			return 0;
		} else {
			return 1 + countSongsRecursive(cur.next);
		} 
	}

	public int countSongs() {
		int result = countSongsRecursive(head);
		return result;
	}
	
		
	/*
	 * Purpose: gets the total duration of all songs in this list
	 * Parameters: none
	 * Returns: int - the total duration of all songs in this list
	 */
	private int totalDurationRecursive(SongNode cur) {
		if (cur == null) {
			return 0;
		} else {
			return (cur.getData().getDuration() + totalDurationRecursive(cur.next));
		}
	}
	public int totalDuration() {
		return totalDurationRecursive(head);
	}
	
	
	/*
	 * Purpose: counts the songs in this list by an artist with artistName
	 * Parameters: String artistName - the name of the artist to search for
	 * Returns: int - number of songs by artistName
	 */
	private int songsByArtistRecursive(SongNode cur, String target) {
		if (cur == null) {
			return 0;
		} else {
			if (cur.getData().getArtist().equals(target)) {
				return 1 + songsByArtistRecursive(cur.next, target);
			} else {
				return songsByArtistRecursive(cur.next, target);
			}
		}
	}

	public int countSongsByArtist(String artistName) {
		return songsByArtistRecursive(head, artistName);
	}
	
	
	/*
	 * Purpose: determines whether this list contains a song by artistName
	 * Parameters: String artistName - the name of the artist to search for
	 * Returns: boolean - true if a song by artistName is found
	 */
	private boolean containsArtistRecursive(SongNode cur, String name) {
		if (cur == null) {
			return false;
		} else {
			if (cur.getData().getArtist().equals(name)) {
				return true;
			} else {
				return containsArtistRecursive(cur.next, name);
			}
		}
	}

	public boolean containsArtist(String artistName) {
		return containsArtistRecursive(head, artistName);
	}
	
	
	/*
	 * Purpose: gets the longest song in the list
	 * Parameters: none
	 * Returns Song - the longest song in the list
	 *                or null if the list is empty
	 */
	private Song longestSongRecursive(SongNode cur, SongNode longest) {
		if (cur == null) {
			return longest.getData();

		} else {
			int curDuration = cur.getData().getDuration();
			int longestDuration = longest.getData().getDuration();
			
			if (curDuration > longestDuration) {
				longest = cur;
			}
			return longestSongRecursive(cur.next, longest);
		}
	}
	public Song longestSong() {
		if (head == null) {
			return null;
		} else {
			return longestSongRecursive(head, head);
		}
	}
	
		
	/*
	 * Purpose: get the total duration of all songs in the list
	 *          before the first song by artistName
	 * Parameters: String artistName - the artist name to search for
	 * Returns int - the duration of all songs before the first
	 *               song by artistName, or -1 if no song by 
	 *               artistName is found.
	 */
	private int totalTimeBeforeRecursive(SongNode cur, String name) {
		if (cur == null || !containsArtist(name)) {
			return -1;
		} else {
			String curName = cur.getData().getArtist();
			if (!curName.equals(name)) {
				return cur.getData().getDuration() + totalTimeBeforeRecursive(cur.next, name);
			} else {
				return 0;
			}
		}
	}

	public int totalTimeUntilArtist(String artistName) {
		return totalTimeBeforeRecursive(head, artistName);
	}
	
}