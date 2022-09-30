package step07;

import java.util.HashSet;
import java.util.Set;

public class SmartPhoneHashSet implements ISmartPhone {
	private static SmartPhoneHashSet instance;
	private Set<Contact> dataSet;
	
	private SmartPhoneHashSet() {
		dataSet = new HashSet<Contact>();
	}
	
	public static SmartPhoneHashSet getInstance() {
		if(instance == null) {
			instance = new SmartPhoneHashSet();
		}
		return instance;
	}

	@Override
	public Contact findContactDataByName(String name) {
		for(Contact data: dataSet) {
			if(data.getName().equals(name)) {
				return data;
			}
		}
		return null;
	}

	@Override
	public void deleteContactDataByName(String name) {
		if(dataSet.isEmpty() || dataSet.size() == 0) {
			System.out.println("전화번호부 데이터가 존재하지 않습니다.");
			return;
		}
		
		Contact data = findContactDataByName(name);
		
		if(dataSet.remove(data)) {
			System.out.println(name + " 데이터 삭제가 완료되었습니다.");
		} else {
			System.out.println("삭제할 데이터가 존재하지 않습니다.");
		}
	}

	@Override
	public void insertContactData(Contact data) {
		if(data == null) {
			System.out.println("데이터 확인 필요.");
			return;
		}
		
		if(dataSet.add(data)) {
			System.out.println("데이터 입력이 완료 되었습니다.");
		} else {
			System.out.println("데이터 입력 실패, 중복 데이터를 확인해주세요.");
		}
	}

	@Override
	public void updateContactData(Contact data) {
		if(data == null) {
			System.out.println("데이터 확인 필요.");
			return;
		}
		if(dataSet.isEmpty() || dataSet.size() == 0) {
			System.out.println("전화번호부 데이터가 존재하지 않습니다.");
			return;
		}
		
		Contact findData = findContactDataByNameAndPhoneNumber(data.getName(), data.getPhoneNumber());
		if(findData != null) {
			System.out.println("중복되는 데이터가 존재합니다.");
		}

		if(dataSet.add(data)) {
			System.out.println("데이터 수정이 완료 되었습니다.");
			dataSet.remove(findData);
		} else {
			System.out.println("데이터 입력 실패, 중복 데이터를 확인해주세요.");
		}
	}

	@Override
	public Contact findContactDataByNameAndPhoneNumber(String name, String phoneNum) {
		for(Contact data: dataSet) {
			if(data.getName().equals(name) && data.getPhoneNumber().equals(phoneNum)) {
				return data;
			}
		}
		return null;
	}

	@Override
	public void printContactAllData() {
		if(dataSet.isEmpty() || dataSet.size() == 0) {
			System.out.println("전화번호부 데이터가 존재하지 않습니다.");
			return;
		}
		
		for(Contact data : dataSet) {
			data.showData();
		}
	}

}
