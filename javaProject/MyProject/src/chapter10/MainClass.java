package chapter10;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("입력하세요(영문 및 숫자)>>");
		String str = scan.nextLine();
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
		
		try {
			if(!pattern.matcher(str).find()) {
				throw new BadIdInputException("입력 값은 영문 및 숫자만 가능합니다.");
			}
		} catch (BadIdInputException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.print("입력하세요(숫자)>>");
		try {
			int result = scan.nextInt();
			System.out.println("입력한 값은 " + result);
		} catch (InputMismatchException e) {
			System.out.println("데이터 입력이 잘못되었습니다.");
		}
		
		scan.close();
	}

}
