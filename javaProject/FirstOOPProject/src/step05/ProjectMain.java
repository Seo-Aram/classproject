package step05;
import java.util.Scanner;

enum MENU {CLOSE, INSERT, UPDATE, SEARCH, DELETE, PRINT_ALL};
enum CLASS_TYPE {CONTACT, COMPANY, CUSTOMER};

public class ProjectMain {
	static Scanner in = new Scanner(System.in);
	
	// 공백 입력은 추가 작업을 하지 않았음. 
	public static void main(String[] args) {
		SmartPhone phoneData = SmartPhone.getInstance();
		int input;
		String name;
		
		while(true) {
			input = printMenu();
			
			switch(input) {
				case 1: // 입력
				{
					System.out.println("연락처 입력");
					
					insertUpdateContact(MENU.INSERT, -1);
					
					break;
				}
				case 2: // 수정
				{
					System.out.println("연락처 수정");
					
					System.out.print("수정할 연락처 이름>>");
					name = in.nextLine();
					
					int index = phoneData.findContactIndexForByName(name);
					if(index == -1) {
						System.out.println("해당 데이터는 존재하지 않습니다.");
						continue;
					}
					
					insertUpdateContact(MENU.UPDATE, index);

					break;
				}
				case 3: // 검색
				{
					System.out.print("검색하고자 하는 이름을 입력하세요>>");
					name = in.nextLine();
					
					Contact data = phoneData.findContactDataForByName(name);
					if(data == null ) {
						System.out.println("데이터가 존재하지 않습니다.");
					} else {
						data.showData();
					}
					
					break;
				}
				case 4: // 삭제
				{
					System.out.print("삭제할 연락처의 이름을 입력하세요>>");
					name = in.nextLine();
					
					phoneData.deleteContactDataForName(name);
					
					break;
				}
				case 5: // 출력
				{
					System.out.println("연락처 내역 전체 출력");
					phoneData.printContactAllData();
					break;
				}
				case 0:
				{
					System.out.println("연락처를 종료합니다.");
					in.close();
					return;
				}
				default:
				{
					System.out.println("잘못 입력했습니다.");
				}
			}
			System.out.println();
		}
	}
	
	static int printMenu() {
		System.out.println("======= 연락처 =======");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 검색");
		System.out.println("4. 삭제");
		System.out.println("5. 출력");
		System.out.println();
		System.out.println("0. 종료");
		System.out.println("=======      =======");
		System.out.print("원하시는 항목을 입력하세요 >> ");	
		
		String input = in.nextLine();
		int result;
		try {
			result = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("데이터 입력이 잘못되었습니다.");
			System.out.println(e.getMessage());
			result = -1;
		}
		
		return result;
	}
	
	static void insertUpdateContact(MENU menu, int index) {
		SmartPhone phoneData = SmartPhone.getInstance();
		Contact data = null;
		
		String name, phoneNumber, email, address, group, birth;

		System.out.print("그룹 구분(회사:1 / 거래처:2)>>");
		String input = in.nextLine();
		int inputType = 0;
		
		try { // parseInt시 문제 발생하지 않게 처리
			inputType = Integer.parseInt(input);
			
			// 코드가 너무 지저분함
			if(inputType != CLASS_TYPE.COMPANY.ordinal() && inputType != CLASS_TYPE.CUSTOMER.ordinal()) {
				throw new Exception("해당 데이터는 입력할 수 없습니다.");
			}	
		} catch (Exception e) {
			System.out.println("잘못된 데이터 입력");
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.print("이름>>");
		name = in.nextLine();
		System.out.print("전화번호>>");
		phoneNumber = in.nextLine();
		System.out.print("e-Mail>>");
		email = in.nextLine();
		System.out.print("주소>>");
		address = in.nextLine();
		System.out.print("생일>>");
		birth = in.nextLine();
		System.out.print("그룹>>");
		group = in.nextLine();
		
		if(inputType == CLASS_TYPE.COMPANY.ordinal()) {
			String company, department, position;
			System.out.print("회사>>");
			company = in.nextLine();
			System.out.print("부서>>");
			department = in.nextLine();
			System.out.print("직책>>");
			position = in.nextLine();
			
			data = new CompanyContact(name, phoneNumber, email, address, birth, group, company, department, position);
		} else if(inputType == CLASS_TYPE.CUSTOMER.ordinal()) {
			String company, item, position;
			System.out.print("거래처>>");
			company = in.nextLine();
			System.out.print("거래 물품>>");
			item = in.nextLine();
			System.out.print("직책>>");
			position = in.nextLine();
			
			data = new CustomerContact(name, phoneNumber, email, address, birth, group, company, item, position);
		}

		int phoneNumIndex = phoneData.findContactIndexForByPhoneNumber(phoneNumber);
		if(phoneNumIndex != -1) {
			System.out.println("중복 된 전화번호가 존재합니다. 데이터를 확인해주세요.");
			return;
		}
		if(menu == MENU.UPDATE) {
			phoneData.updateContactDataForIndex(index, data);
		} else if(menu == MENU.INSERT) {
			phoneData.insertContactData(data);
		}
		
	}
}
