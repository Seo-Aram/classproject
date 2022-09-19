package chapter05;

public class Member {
	/*
	 * Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고, main()메소드에 해당 메소드를 호출해서 결과를 확인해보세요.
	 * 단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다.
	 * ① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	 * ② 위에서 정의한 정보를 출력하는 메소드 정의
	 * ③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
	 * ④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
	 */
	
	private String name;
	private String phoneNumber;
	private String major;
	private int grade;
	private String eMail;
	private String birth;
	private String address;
	
	public Member(String name, String phoneNumber, String major, int grade, String eMail, String birth,
			String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.eMail = eMail;
		this.birth = birth;
		this.address = address;
	}

	public Member(String name, String phoneNumber, String major, int grade, String eMail) {
		this(name, phoneNumber, major, grade, eMail, "", "");
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", phoneNumber=" + phoneNumber + ", major=" + major + ", grade=" + grade
				+ ", eMail=" + eMail + ", birth=" + birth + ", address=" + address + "]";
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void printMemberData() {
		System.out.println("==========Member Data==========");
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("전공: " + major);
		System.out.println("학년: " + grade);
		System.out.println("e-mail: " + eMail);
		System.out.println("생일: " + birth);
		System.out.println("주소: " + address);
	}
	
}
