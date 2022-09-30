package step06;

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
	 * index에 위치한 데이터를 반환하는 함수
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
	 * Contact데이터를 받아서 업데이트 하는 함수
	 * @param index
	 * @param data
	 */
	public void updateContactDataForIndex(int index, Contact data) {
		if(data == null) {
			System.out.println("데이터 확인 필요.");
			return;
		}
		if(findContactIndexForByPhoneNumber(data.getPhoneNumber()) != -1) {
			System.out.println("중복 된 데이터가 존재합니다.");
		}
		if(index < 0 || MAX_SIZE <= index || list[index] == null) {
			System.out.println("데이터가 존재하지 않습니다.");
		} else {
			list[index] = data;
		}
	}
	
	/**
	 * 데이터 입력 함수
	 * @param data
	 */
	public void insertContactData(Contact data) {
		if(data == null) {
			System.out.println("데이터 확인 필요.");
			return;
		}
		if(findContactIndexForByName(data.getName()) != -1
				|| findContactIndexForByPhoneNumber(data.getPhoneNumber()) != -1) {
			System.out.println("중복 된 데이터가 존재합니다.");
		}
		
		for(int i = 0; i < MAX_SIZE; ++i) {
			if(list[i] == null) {
				list[i] = data;
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
	public Contact findContactDataForByName(String name) {
		for(Contact data : list) {
			if(data != null && data.getName().equals(name)) {
				return data;
			}
		}
		
		return null;
	}
	
	/**
	 * phoneNumber와 동일한 데이터를 반환하는 함수
	 * @param phoneNum
	 * @return
	 */
	public Contact findContactDataForByPhoneNumber(String phoneNum) {
		for(Contact data : list) {
			if(data != null && data.getPhoneNumber().equals(phoneNum)) {
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
	public int findContactIndexForByName(String name) {
		for(int i = 0; i < MAX_SIZE; ++i) {
			if(list[i] != null && list[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	
	/**
	 * name과 동일한 데이터의 index를 반환하는 함수
	 * @param phoneNum
	 * @return int index
	 */
	public int findContactIndexForByPhoneNumber(String phoneNum) {
		for(int i = 0; i < MAX_SIZE; ++i) {
			if(list[i] != null && list[i].getPhoneNumber().equals(phoneNum)) {
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
		int index = findContactIndexForByName(name);
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
				data.showData();
			}
		}
	}
}