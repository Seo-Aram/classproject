package chapter02;

public class VariableTest {
	public static void main(String[] args) {
		int result = add(100, 200);
		System.out.println(result);
		
		addPrint(10, 21);
	}
	
	public static int add(int a, int b) {
		int result = a + b;
		return result;
	}
	
	public static void addPrint(int a, int b) {
		System.out.println(a + b);
	}
	
	
}
