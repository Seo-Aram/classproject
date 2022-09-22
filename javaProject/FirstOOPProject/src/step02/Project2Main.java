package step02;
import java.util.Scanner;

enum MENU {CLOSE, INSERT, UPDATE, SEARCH, DELETE, PRINT_ALL};

public class Project2Main {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		SmartPhone phoneData = SmartPhone.getInstance();
		int input;
		String name;
		
		while(true) {
			printMenu();
			
			input = in.nextInt();
			in.nextLine();
			
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
					
					int index = phoneData.findContactIndexForName(name);
					if(index == -1) {
						System.out.println("해당 데이터는 존재하지 않습니다.");
						continue;
					}
					System.out.println("수정할 데이터가 없을 경우 공백으로 남기시면 수정되지 않습니다.");
					
					insertUpdateContact(MENU.UPDATE, index);

					break;
				}
				case 3: // 검색
				{
					System.out.print("검색하고자 하는 이름을 입력하세요>>");
					name = in.nextLine();
					
					Contact data = phoneData.findContactDataForName(name);
					if(data == null ) {
						System.out.println("데이터가 존재하지 않습니다.");
					} else {
						data.printData();
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
	
	static void printMenu() {
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
	}
	
	static void insertUpdateContact(MENU type, int index) {
		SmartPhone phoneData = SmartPhone.getInstance();
		
		String name, phoneNumber, email, address, group, birth;
		
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
		

		if(type == MENU.UPDATE) {
			phoneData.updateContactDataForIndex(index, name, phoneNumber, email, address, birth, group);
		} else if(type == MENU.INSERT) {
			phoneData.insertContactData(name, phoneNumber, email, address, birth, group);
		}
		
	}
}
