package chapter07;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] people = new Person[2];
		people[0] = new Male("Kim", 19900102);
		people[1] = new Female("Sin", 19911127);
		
		for(Person s : people) {
			s.printGreeting();
		}
	}

}
