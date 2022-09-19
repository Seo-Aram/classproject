package chapter05;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member = new Member("Seo", "000-0000-0000", "GameDev", 4, "ab@cd.com", "12/11", "Seoul");
		Member member2 = new Member("Kim", "010-0000-0000", "ComputerDev", 4, "ef@cd.com");
		
		System.out.println(member);
		System.out.println(member2);
		
		member.printMemberData();
		member2.printMemberData();
	}

}
