package chapter07;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] people = new Person[2];
		people[0] = new Male("Kim", "900217-1000000");
		people[1] = new Female("Sin", "020723-4000000");
		
		for(Person s : people) {
			s.printGreeting();
		}
	}

}
