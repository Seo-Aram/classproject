package chapter02;

public class Calculator {
	/*
	 * 1. 덧셈 함수
	 * 2. 뺄셈 함수
	 * 3. 곱셈 함수
	 * 4. 나눗셈 함수
	 */
	public static int sum(int num1,int num2) {
		int result = num1 + num2;
		return result;
	}
	
	public static int sub(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
	
	public static int mul(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}
	
	public static double div(int num1, int num2) {
		double result = (double)num1 / num2;
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(10, 20));
		System.out.println(sub(10, 20));
		System.out.println(mul(10, 20));
		System.out.println(div(10, 20));
	}
}
