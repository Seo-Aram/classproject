package quiz02;

import java.util.Scanner;

public class Calculator {
	public static void sum (int num1, int num2) {
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
	}
	
	public static void sub (int num1, int num2) {
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
	}
	
	public static void mul (int num1, int num2) {
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
	}
	
	public static void div (double num1, double num2) {
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
	}
	
	public static double getCircumference (double r) {
		return 2 * Math.PI * r;
	}
	
	public static double getCircleArea (double r) {
		return Math.PI * Math.pow(r, 2);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("숫자 1 입력: ");
		int num1 = in.nextInt();
		in.nextLine();
		System.out.print("숫자 2 입력: ");
		int num2 = in.nextInt();
		in.nextLine();
		
		System.out.print("반지름 입력: ");
		double r = in.nextDouble();
		in.nextLine();
		
		sum(num1, num2);
		sub(num1, num2);
		mul(num1, num2);
		div(num1, num2);
		
		System.out.println("반지름 " + r + "인 원의 둘레: " + getCircumference(r));
		System.out.println("반지름 " + r + "인 원의 넓이: " + getCircleArea(r));
		
		in.close();
	}
}
