public class Competitor {
	private String name;
	private int score;
	
	public Competitor(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public String toString() {
		return "Name: "+name+" ("+score+")";
	}
	
	public boolean equals(Competitor other) {
		return this.name.equals(other.name)
			&& this.score == other.score;
	}
}