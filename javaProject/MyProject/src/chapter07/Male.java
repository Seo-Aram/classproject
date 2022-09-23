package chapter07;

class Male extends Person {

	public Male(String name, int birth) {
		super(name, birth);
	}

	@Override
	public void printGreeting() {
		// TODO Auto-generated method stub
		super.printGreeting();
		System.out.println("저는 남자입니다.");
	}
}