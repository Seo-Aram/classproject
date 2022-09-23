package chapter07;

class Female extends Person {

	public Female(String name, int birth) {
		super(name, birth);
	}

	@Override
	public void printGreeting() {
		// TODO Auto-generated method stub
		super.printGreeting();
		System.out.println("저는 여자입니다.");
	}
}