package chapter08;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calculator = new CalculatorMachine();
		
		Scanner in = new Scanner(System.in);
		int input;
		int iNum1, iNum2;
		double dNum1, dNum2;
		
		while(true) {
			printMenu();
			try {
				input = Integer.parseInt(in.nextLine());
			
				switch(input) {
					case 1:
					{
						System.out.print("a: ");
						iNum1 = Integer.parseInt(in.nextLine());
						System.out.print("b: ");
						iNum2 = Integer.parseInt(in.nextLine());
						
						System.out.println(iNum1 + " + " + iNum2 + " = " + calculator.add(iNum1, iNum2));
						break;
					}
					case 2:
					{
						System.out.print("a: ");
						iNum1 = Integer.parseInt(in.nextLine());
						System.out.print("b: ");
						iNum2 = Integer.parseInt(in.nextLine());

						System.out.println(iNum1 + " - " + iNum2 + " = " + calculator.substract(iNum1, iNum2));
						break;
					}
					case 3:
					{
						System.out.print("a: ");
						iNum1 = Integer.parseInt(in.nextLine());
						System.out.print("b: ");
						iNum2 = Integer.parseInt(in.nextLine());

						System.out.println(iNum1 + " * " + iNum2 + " = " + calculator.multiply(iNum1, iNum2));
						break;
					}
					case 4:
					{
						System.out.print("a: ");
						dNum1 = Double.parseDouble(in.nextLine());
						System.out.print("b: ");
						dNum2 = Double.parseDouble(in.nextLine());
						
						System.out.println(dNum1 + " / " + dNum2 + " = " + calculator.divide(dNum1, dNum2));
						break;
					}
					case 0:
					{
						System.out.println("종료합니다.");
						in.close();
						return;
					}
				default:
					System.out.println("잘못된 입력입니다.");
				}

			} catch (Exception e) {
				System.out.println("잘못된 입력입니다. " + e.getMessage() );
				continue;
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("-----------MENU-----------");
		System.out.println("1. 더하기");
		System.out.println("2. 빼기");
		System.out.println("3. 곱하기");
		System.out.println("4. 나누기");
		System.out.println("0. 종료");
		System.out.println("-----------    -----------");
		System.out.print("원하는 항목 입력>>");
	}
}
