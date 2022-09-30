package step06;

public class ProjectMain {
	// 공백 입력은 추가 작업을 하지 않았음. 
	public static void main(String[] args) {
		SmartPhone phoneData = SmartPhone.getInstance();
		DataContext context = DataContext.getInstance();
		
		int input;
		String name;
		
		while(true) {
			input = context.printInputMenu();
			
			switch(input) {
				case 1: // 입력
				{
					System.out.println("연락처 입력");
					
					Contact data = context.inputContactData();
					
					phoneData.insertContactData(data);
					
					break;
				}
				case 2: // 수정
				{
					System.out.println("연락처 수정");
					
					System.out.print("수정할 연락처 이름>>");
					name = context.inputString();
					
					int index = phoneData.findContactIndexForByName(name);
					if(index == -1) {
						System.out.println("해당 데이터는 존재하지 않습니다.");
						continue;
					}

					Contact data = context.inputContactData();
					
					phoneData.updateContactDataForIndex(index, data);

					break;
				}
				case 3: // 검색
				{
					System.out.print("검색하고자 하는 이름을 입력하세요>>");
					name = context.inputString();
					
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
					name = context.inputString();
					
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
}
