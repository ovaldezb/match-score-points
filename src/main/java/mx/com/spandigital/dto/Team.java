package mx.com.spandigital.dto;

public class Team implements Comparable<Team>{

	private String name;
	private Integer points;
	private int score;
	
	public Team(String name, int points, int score) {
		this.name = name;
		this.points = points;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Team o) {
		if(this.getPoints()!=o.getPoints()) {
			return o.getPoints().compareTo(this.getPoints());
		}else {
			return this.getName().compareTo(o.getName());
		}
		
	}
	
}
