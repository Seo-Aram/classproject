package step02;

public class SmartPhone {
	private Contact[] list;
	private final int MAX_SIZE = 10;
	
	public SmartPhone() {
		list = new Contact[MAX_SIZE];
	}

	public Contact getContactDataForIndex(int index) {
		if(index < 0 || list.length <= index) {
			return null;
		}
		return list[index];
	}
	
	public void updateContactDataForIndex(int index, String name, String phoneNumber
			, String eMail, String address, int birth, String group) {
		if(index < 0 || MAX_SIZE <= index || list[index] == null) {
			System.out.println("데이터가 존재하지 않습니다.");
		} else {
			/*list[index].setName(name);
			list[index].setPhoneNumber(phoneNumber);
			list[index].seteMail(eMail);
			list[index].setAddress(address);
			list[index].setBirth(birth);
			list[index].setGroup(group);*/
			
			list[index] = new Contact(name, phoneNumber, eMail, address, birth, group);
		}
	}
	
	public void insertContactData(String name, String phoneNumber
			, String eMail, String address, int birth, String group) {
		for(int i = 0; i < MAX_SIZE; ++i) {
			if(list[i] == null) {
				list[i] = new Contact(name, phoneNumber, eMail, address, birth, group);
				System.out.println("데이터 입력 완료");
				return;
			}
		}
		System.out.println("연락처가 가득 찼습니다.");
	}
	
	public Contact findContactDataForName(String name) {
		for(Contact data : list) {
			if(data != null && data.getName().equals(name)) {
				return data;
			}
		}
		
		return null;
	}
	
	public int findContactIndexForName(String name) {
		for(int i = 0; i < MAX_SIZE; ++i) {
			if(list[i] != null) {
				if(list[i].getName().equals(name)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void deleteContactDataForName(String name) {
		for(int i = 0; i < MAX_SIZE; ++i) {
			if(list[i] != null) {
				if(list[i].getName().equals(name)) {
					list[i] = null;
					System.out.println("데이터 삭제 완료.");
					return;
				}
			}
		}
		
		System.out.println("올바른 데이터를 찾지 못했습니다.");
	}
	
	public void printContactAllData() {
		for(Contact data : list) {
			if(data != null) {
				data.printData();
			}
		}
	}
}