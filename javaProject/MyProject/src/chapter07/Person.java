package chapter07;

import java.time.LocalDate;

class Person {
	private String name;
	private int birth;
	private static int currYear = LocalDate.now().getYear();

	public void printGreeting() {
		System.out.println("안녕하세요. 저는 " + name + "입니다. " + (currYear - (birth/10000) + 1) + "살 입니다.");
	}

	public Person(String name, int birth) {
		this.name = name;
		this.birth = birth;
	}
}
