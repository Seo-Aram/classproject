package chapter06;



public class Student {
	private String name;
	private int language;
	private int math;
	private int english;
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		if(language < 0 || 100 < language) {
			System.out.println("국어 점수가 잘못 입력 되었습니다.");
			return;
		}
		this.language = language;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		if(math < 0 || 100 < math) {
			System.out.println("수학 점수가 잘못 입력 되었습니다.");
			return;
		}
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		if(english < 0 || 100 < english) {
			System.out.println("영어 점수가 잘못 입력 되었습니다.");
			return;
		}
		this.english = english;
	}
	
	public int getTotalScore() {
		return language + math + english;
	}
	
	public double getAverage() {
		return (double)Math.round(((double)getTotalScore() / 3) * 100) / 100;
	}
	
}
