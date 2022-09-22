package step02;

public class SmartPhone {
	private Contact[] list;
	private final int MAX_SIZE = 10;
	
	private static SmartPhone instance = null;
	
	private SmartPhone() {
		list = new Contact[MAX_SIZE];
	}
	
	/**
	 * 싱글톤 객체
	 * @return SmartPhone
	 */
	public static SmartPhone getInstance() { // 싱글톤 객체
		if(instance == null) {
			instance = new SmartPhone();
		}
		return instance;
	}

	/**
	 * index에 위치한 데이터를 반환하느 함수
	 * @param index
	 * @return Contact
	 */
	public Contact getContactDataForIndex(int index) {
		if(index < 0 || list.length <= index) {
			return null;
		}
		return list[index];
	}
	
	/**
	 * 데이터 업데이트 함수
	 * @param index
	 * @param name
	 * @param phoneNumber
	 * @param eMail
	 * @param address
	 * @param birth
	 * @param group
	 */
	public void updateContactDataForIndex(int index, String name, String phoneNumber
			, String eMail, String address, String birth, String group) {
		if(index < 0 || MAX_SIZE <= index || list[index] == null) {
			System.out.println("데이터가 존재하지 않습니다.");
		} else {
			if(name != null && name.trim().length() > 0) {
				list[index].setName(name);
			}
			
			if(phoneNumber != null && phoneNumber.trim().length() > 0) {
				list[index].setPhoneNumber(phoneNumber);
			}

			if(eMail != null && eMail.trim().length() > 0) {
				list[index].seteMail(eMail);
			}

			if(address != null && address.trim().length() > 0) {
				list[index].setAddress(address);
			}

			if(birth != null && birth.trim().length() > 0) {
				list[index].setBirth(birth);
			}

			if(group != null && group.trim().length() > 0) {
				list[index].setGroup(group);
			}
		}
	}
	
	/**
	 * 데이터 입력 함수
	 * @param name
	 * @param phoneNumber
	 * @param eMail
	 * @param address
	 * @param birth
	 * @param group
	 */
	public void insertContactData(String name, String phoneNumber, 
			String eMail, String address, String birth, String group) {
		for(int i = 0; i < MAX_SIZE; ++i) {
			if(list[i] == null) {
				list[i] = new Contact(name, phoneNumber, eMail, address, birth, group);
				System.out.println("데이터 입력 완료");
				return;
			}
		}
		System.out.println("연락처가 가득 찼습니다.");
	}
	
	/**
	 * name과 동일한 데이터를 반환하는 함수
	 * @param name
	 * @return Contact
	 */
	public Contact findContactDataForName(String name) {
		for(Contact data : list) {
			if(data != null && data.getName().equals(name)) {
				return data;
			}
		}
		
		return null;
	}
	
	/**
	 * name과 동일한 데이터의 index를 반환하는 함수
	 * @param name
	 * @return int index
	 */
	public int findContactIndexForName(String name) {
		for(int i = 0; i < MAX_SIZE; ++i) {
			if(list[i] != null && list[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * name과 동일한 데이터를 찾아 삭제하는 함수
	 * @param name
	 */
	public void deleteContactDataForName(String name) {
		int index = findContactIndexForName(name);
		if(index != -1) {
			list[index] = null;
			System.out.println("데이터 삭제 완료.");
			return;
		}
		
		System.out.println("올바른 데이터를 찾지 못했습니다.");
	}
	
	/**
	 * 모든 데이터 print
	 */
	public void printContactAllData() {
		for(Contact data : list) {
			if(data != null) {
				data.printData();
			}
		}
	}
}