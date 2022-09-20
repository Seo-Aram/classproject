/*
 * main()메소드를 정의합니다.
 연락처 데이터를 저장하는 인스턴스를 생성합니다.
 변수 값을 반환하는 각각의 메소드를 호출해서 각 데이터를 출력문으로 출력합니다.
 생성된 인스턴스의 정보 출력 메소드를 호출합니다.
 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다.
 인스턴스의 출력메소드를 다시 실행합니다
 */
import data.Contact;

public class ProjectMain {
	public static void main(String[] args) {
		Contact data = new Contact("Seo", "000-0000-0000", "email", "seoul", 20020101, null);
		
		System.out.println("이름: " + data.getName());
		System.out.println("전화번호: " + data.getPhoneNumber());
		System.out.println("이메일: " + data.geteMail());
		System.out.println("주소: " + data.getAddress());
		System.out.println("생일: " + data.getBirth());
		System.out.println("그룹: " + data.getGroup());
		System.out.println();
		
		data.setName("A");
		data.setPhoneNumber("010-0000-0000");
		data.seteMail("bMail");
		data.setAddress("Gyeongi");
		data.setBirth(20020703);
		data.setGroup("A");
		
		data.printData();
	}
}
