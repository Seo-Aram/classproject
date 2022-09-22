package step03;

class CustomerContact extends Contact {
	private String company;
	private String item;
	private String position;
	
	public CustomerContact(String name, String phoneNumber, String eMail, String address, String birth, String group,
			String company, String item, String position) {
		super(name, phoneNumber, eMail, address, birth, group);
		this.company = company;
		this.item = item;
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return item;
	}

	public void setDepartment(String item) {
		this.item = item;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public void printData() {
		System.out.println("******* 거래처 정보");
		super.printData();

		System.out.println("거래처: " + company);
		System.out.println("거래 물품: " + item);
		System.out.println("직책: " + position);
	}
	
	

}
