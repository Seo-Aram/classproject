package first;

import java.util.Scanner;

// 키워드: 자바 내부에서 약속된 단어, 명령어
// class: 클래스를 정의해줌
public class ConsolePrintTest {
	public static void main(String[] args) {
		System.out.print("JAVA는 \"객체지향 언어\"입니다.\n");
		
		Scanner in = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = in.nextLine();
		System.out.printf("내 이름은 %s 입니다.\n", name);
		in.close();
	}
}
