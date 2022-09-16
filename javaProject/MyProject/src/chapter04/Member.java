package chapter04;

import java.time.LocalDate;
import java.util.Scanner;

public class Member {
	
	static int nowYear = LocalDate.now().getYear();

	public static void printName(String name) {
		System.out.println("안녕하세요! " + name + " 입니다.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		System.out.print("태어난 해 입력: ");
		int year = in.nextInt();
		in.nextLine();
		
		printCheckFreeVaccine(year);
		printCheckMedical(year);
		
		in.close();
	}
	
	public static void printCheckFreeVaccine(int year) {
		//나이를 계산해야 함
		int age = getAge(year);
		if(age < 15 || 65 <= age) {
			System.out.println("무료예방접종이 가능합니다.");
		} else {
			System.out.println("무료접종 대상이 아닙니다.");
		}
	}
	
	public static void printCheckMedical(int year) {
		int age = getAge(year);
		if(20 <= age && (year + nowYear) % 2 == 0) {
			System.out.println("무료 건강 검진 대상입니다.");
			if(40 <= age) {
				System.out.println("무료 암 검사 대상입니다.");
			}
		}
	}
	
	public static int getAge(int year) {
		return nowYear - year + 1;
	}
	
}
