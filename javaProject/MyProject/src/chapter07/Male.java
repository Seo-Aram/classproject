package chapter07;

class Male extends Person {

	public Male(String name, String personNum) {
		super(name, personNum);
	}

	@Override
	public void printGreeting() {
		// TODO Auto-generated method stub
		super.printGreeting();
		System.out.println("저는 남자입니다.");
	}
}