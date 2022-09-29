package chapter11;

class FootballPlayer implements Comparable<FootballPlayer>{
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
	
	@Override
	public int compareTo(FootballPlayer f) {
		int compare = this.team.compareTo(f.getTeam());
		if(compare == 0) {
			compare = this.name.compareTo(f.getName());
			if(compare == 0) {
				compare = Integer.compare(this.number, f.getNumber());
			}
		}
		return compare;
	}
}
