package quiz01;

import java.util.Scanner;

public class Member {

	public static void printName(String name) {
		System.out.println("안녕하세요! " + name + " 입니다.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printName("Seo Aram");
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("이름 입력: ");
		String name = in.nextLine();
		System.out.print("나이 입력: ");
		int age = in.nextInt();
		in.nextLine();
		System.out.print("키 입력: ");
		double height = in.nextDouble();
		in.nextLine();
		boolean hasBook = true;
		in.close();
		
		System.out.printf("이름: %s, 나이: %d, 키: %f, 책 보유 정보: %b", name, age, height, hasBook);
	}

}
