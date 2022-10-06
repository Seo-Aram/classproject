package chapter12;

import java.io.Serializable;

class FootballPlayer implements Serializable{
	private static final long serialVersionUID = -7030783023821156562L;
	
	private String name;
	private int number;
	private String team;
	private int age;
		
	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getTeam() {
		return team;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public int hashCode() {
		String str = this.name + this.age + this.team;
		return str.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof FootballPlayer) {
			FootballPlayer f = (FootballPlayer)o;
			if(this.name.equals(f.getName()) && this.age == f.getAge() && this.team.equals(f.getTeam()))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + ", Age: " + this.age + ", team: " + this.team + ", backNum: " + this.number;
	}
}
