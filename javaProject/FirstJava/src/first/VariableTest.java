package first;

public class VariableTest {
	public static void main(String[] args) {
		/*
		 * 변수
		 * : 데이터를 저장할 메모리 공간 생성
		 * : 메모리에 찾아갈 수 있는 주소 역할
		 */
		
		System.out.println(AddNumber(10, 15));
		addResultPrint(10, 30);
	}
	
	public static int AddNumber(int a, int b) {
		return a+b;
		
	}
	
	public static void addResultPrint(int num1, int num2) {
		int sum = num1 + num2;
		
		System.out.println(sum);
	}
}
