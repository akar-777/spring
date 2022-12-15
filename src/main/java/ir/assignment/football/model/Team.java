package ir.assignment.football.model;

public class Team {
	private int id;
	private String name;
	private String city;
	private String shortName;

	public Team() {
	}

	public Team(int id, String name, String city, String shortName) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.shortName = shortName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
}
