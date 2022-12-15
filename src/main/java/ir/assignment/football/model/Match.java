package ir.assignment.football.model;

public class Match {
	private int id;
	private int homeTeam;
	private int awayTeam;
	private int homeTeamGoal;
	private int awayTeamGoal;
	private int homeTeamPreGoal;
	private int awayTeamPreGoal;
	private int score;
	private int status;

	public Match() {
	}

	public Match(int id, int homeTeam, int awayTeam, int homeTeamGoal, int awayTeamGoal, int homeTeamPreGoal, int awayTeamPreGoal, int score, int status) {
		this.id = id;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamGoal = homeTeamGoal;
		this.awayTeamGoal = awayTeamGoal;
		this.homeTeamPreGoal = homeTeamPreGoal;
		this.awayTeamPreGoal = awayTeamPreGoal;
		this.score = score;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(int homeTeam) {
		this.homeTeam = homeTeam;
	}

	public int getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(int awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeTeamGoal() {
		return homeTeamGoal;
	}

	public void setHomeTeamGoal(int homeTeamGoal) {
		this.homeTeamGoal = homeTeamGoal;
	}

	public int getAwayTeamGoal() {
		return awayTeamGoal;
	}

	public void setAwayTeamGoal(int awayTeamGoal) {
		this.awayTeamGoal = awayTeamGoal;
	}

	public int getHomeTeamPreGoal() {
		return homeTeamPreGoal;
	}

	public void setHomeTeamPreGoal(int homeTeamPreGoal) {
		this.homeTeamPreGoal = homeTeamPreGoal;
	}

	public int getAwayTeamPreGoal() {
		return awayTeamPreGoal;
	}

	public void setAwayTeamPreGoal(int awayTeamPreGoal) {
		this.awayTeamPreGoal = awayTeamPreGoal;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
