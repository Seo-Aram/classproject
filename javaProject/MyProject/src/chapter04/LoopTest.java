package chapter04;

public class LoopTest {
	// for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성
	public static void Quiz01() {
		long result = 1;
		for(int i = 2; i <= 10; result *= i++) ;
		
		System.out.println("10! = " + result);
	}

	/*
	 * 자연수 1부터 시작해서 모든 홀수와 3의 배수인 짝수를 더해 나간다. 
	 * 그리고 그 합이 언제 (몇을 더했을 때) 1000이 넘어서는지, 
	 * 그리고 1000이 넘어선 값은 얼마가 되는지 계산하여 출력하는 프로그램을 작성.
	 * 프로그램 내부에 while문을 무한 루프로 구성하여 작성.
	 */
	public static void Quiz02() {
		int i = 1;
		int sum = 0;
		while(true) {
			if(i % 2 == 1 || i % 3 == 0) {
				sum += i;
			}
			if(1000 <= sum) {
				System.out.println("i의 현재 값: " + i + ", sum: " + sum);
				break;
			}
			
			i++;
		}
	}
	
	/*
	 * 구구단의 짝수 단(2,4,8)만 출력하는 프로그램 작성.
	 * 단, 2단은 2x2까지, 4단은 4x4까지, 8단은 8x8 까지 출력
	 */
	public static void Quiz03() {
		for(int i = 2; i <= 8; i *= 2) {
			System.out.println("=====" + i + "단=====");
			for(int j = 1; j <= i; ++j) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
	}
	
	/*
	 * 다음 식을 만족하는 조합을 찾는 프로그램 작성. 
	 * A B
	 * B A
	 * ------
	 * 9 9
	 * 
	 * 10의 자리 A와 1의 자리 B + 10의 자리 B와 1의 자리 A를 더했을 때 99가 나오는 조합
	 */
	public static void Quiz04() {
		for(int i = 0; i < 10; ++i) {
			System.out.println("A : " + i + ", B : " + (9 - i));
		}
	}
	
	/* n은 0보다 크다는 전제로 함
	 * n=1 일 때  “현재 인원은 1명 입니다.”
	 * n=2 일 때  “현재 인원은 2명 입니다.”
	 * n=3 일 때  “현재 인원은 3명 입니다.”
	 * n>3 일 때  “현재 많은 사람들이 있습니다.”
	 * 위의 내용이 출력 되는 프로그램을 작성. 각각 If 문과 switch 문 사용
	 */
	public static void Quiz05(int n) {
		//if
		if(1 <= n && n <= 3) {
			System.out.println("현재 인원은 " + n + "명 입니다.");
		} else if(3 < n) {
			System.out.println("현재 많은 사람들이 있습니다.");
		}
		
		//switch
		switch(n) {
			case 0: {
				break;
			}
			case 1:case 2: case 3:
			{
				System.out.println("현재 인원은 " + n + "명 입니다.");
				break;
			}
			default:
			{
				System.out.println("현재 많은 사람들이 있습니다.");
			}
		}
		
		// switch + if
		switch(n) {
			case 1:case 2: case 3:
			{
				System.out.println("현재 인원은 " + n + "명 입니다.");
				break;
			}
		}
		if(3 < n) {
			System.out.println("현재 많은 사람들이 있습니다.");
		}
	}
	
	/*
	 * 1 부터 99까지의 합을 구하는 프로그램 작성
	 * while문, for문, do while 문을 각각 사용
	 */
	public static void Quiz06() {
		int whileSum = 0;
		int whileNum = 0;
		while(++whileNum < 100) {
			whileSum += whileNum;
		}
		
		int forSum = 0;
		for(int i = 1; i < 100; ++i) {
			forSum += i;
		}
		
		int doWhileSum = 0;
		int doWhileNum = 1;
		do {
			doWhileSum += doWhileNum++;
		}while(doWhileNum < 100);
		
		System.out.println("1부터 99까지의 합은: " + whileSum + ", " + forSum + ", " + doWhileSum);
	}
	
	public static void main(String[] args) {
		Quiz01();
		Quiz02();
		Quiz03();
		Quiz04();
		Quiz05(3);
		Quiz06();
	}

}
