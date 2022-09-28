package chapter09;

class Person {
	 String name;
	 String personNumber;
	 
	 Person(String name, String personNumber){
		 this.name = name;
		 this.personNumber = personNumber;
	 }
	 
	 @Override
	 public boolean equals(Object o) {
		 if(o != null && o instanceof Person) {
			 return this.personNumber.equals(((Person)o).personNumber);
		 }
		 
		 return false;
	 }
}
