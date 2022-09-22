package step02;

class Contact {

	private String name;
	private String phoneNumber;
	private String eMail;
	private String address;
	private int birth;
	private String group;
	
	public Contact(String name, String phoneNumber, String eMail, String address, int birth, String group) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.address = address;
		this.birth = birth;
		this.group = group;
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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", eMail=" + eMail + ", address=" + address
				+ ", birth=" + birth + ", group=" + group + "]";
	}
	
	public void printData() {
		System.out.println("==========Data==========");
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		System.out.println("e-mail: " + eMail);
		System.out.println("생일: " + birth);
		System.out.println("주소: " + address);
		System.out.println("그룹: " + group);
	}
}
