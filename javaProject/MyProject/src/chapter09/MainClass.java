package chapter09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class MainClass {

	public static void main(String[] args) {
		Person p1 = new Person("Kim", "900209-1000000");
		Person p2 = new Person("Lee", "890122-2000000");
		System.out.println(p1.equals(p2));
		
		long startTime = System.nanoTime();
		long sum = 0;
		for(int i = 0; i <= 100000000; sum += ++i);
		long endTime = System.nanoTime();
		System.out.println("1부터 100000000까지의 합은 " + sum + "이고, 걸린 시간은 " + ((double)endTime - startTime)/1000000000 + "초 입니다.");
		
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print("태어난 날을 입력해주세요(yyyyMMdd): ");
			Date birth = new SimpleDateFormat("yyyyMMdd").parse(scan.nextLine());
			Date curr = new Date();
			
			long passing = (curr.getTime() - birth.getTime()) / 1000 / 60 / 60 / 24;
			System.out.println("태어난 날부터 " + passing + "일 경과했습니다.");
		}catch( Exception e) {
			System.out.println("입력 에러");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		scan.close();
	}

}
