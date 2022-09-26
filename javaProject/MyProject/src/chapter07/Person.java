package chapter07;

import java.time.LocalDate;

class Person {
	private String name;
	private String personNum;

	public void printGreeting() {
		System.out.println("안녕하세요. 저는 " + name + "입니다. " + getAge() + "살 입니다.");
	}

	public Person(String name, String personNum) {
		this.name = name;
		this.personNum = personNum;
	}
	
	int getAge() {
		String tmpYear = personNum.substring(0, 2);
		int gender = Integer.parseInt(personNum.substring(7, 8));
		
		int year = 0;
		if(1 <= gender && gender <= 2) {
			year = Integer.parseInt("19"+tmpYear);
		} else if(3 <= gender && gender <= 4) {
			year = Integer.parseInt("20"+tmpYear);
		}
		
		return LocalDate.now().getYear() - year + 1;
	}
}
