package step07;

import java.util.ArrayList;
import java.util.List;

class SmartPhoneArrayList implements ISmartPhone {
	private static SmartPhoneArrayList instance;
	private List<Contact> dataSet;
	
	private SmartPhoneArrayList() {
		dataSet = new ArrayList<Contact>();
	}
	
	public static SmartPhoneArrayList getInstance() {
		if(instance == null) {
			instance = new SmartPhoneArrayList();
		}
		return instance;
	}

	public int findIndexByName(String name) {
		for(int i = 0; i < dataSet.size(); ++i) {
			if(dataSet.get(i).getName().equals(name))
				return i;
		}
		return -1;
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
		
		int index = findIndexByName(name);
		if(index == -1) {
			System.out.println("삭제할 데이터가 존재하지 않습니다.");
			return;
		}
		
		dataSet.remove(index);
		System.out.println(name + " 데이터 삭제가 완료되었습니다.");
	}
	
	@Override
	public void insertContactData(Contact data) {
		if(data == null) {
			System.out.println("데이터를 확인해주세요.");
			return;
		}
		if(findContactDataByNameAndPhoneNumber(data.getName(), data.getPhoneNumber()) != null) {
			System.out.println("중복된 데이터입니다. 데이터를 확인해주세요.");
			return;
		}
		
		this.dataSet.add(data);
	}

	@Override
	public void updateContactData(Contact data) {
		if(data == null) {
			System.out.println("데이터 확인 필요.");
			return;
		}
		
		if(dataSet.isEmpty() || dataSet.size() == 0) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		
		if(findContactDataByNameAndPhoneNumber(data.getName(), data.getPhoneNumber()) != null) {
			System.out.println("중복된 데이터입니다. 데이터를 확인해주세요.");
			return;
		}
		
		int index = findIndexByName(data.getName());
		if(index == -1) {
			System.out.println("수정할 데이터가 존재하지 않습니다.");
			return;
		}
		
		this.dataSet.set(index, data);
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
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		
		for(Contact data : dataSet) {
			data.showData();
		}
	}

}
