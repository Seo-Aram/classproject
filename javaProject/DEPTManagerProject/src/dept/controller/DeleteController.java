package dept.controller;

import dept.Main;
import dept.dao.MysqlDAO;
import dept.service.DeleteService;

public class DeleteController implements Controller {
	
	DeleteService service = new DeleteService(new MysqlDAO());
	
	public void process() {
		try {
			System.out.println("삭제할 부서 번호를 입력해주세요.");
			System.out.println("부서번호 >>");
			int deptno = Integer.parseInt(Main.sc.nextLine());
			
			int result = service.delete(deptno);
			
			if(result>0) {
				System.out.println("삭제되었습니다.");
			} else {
				System.out.println("삭제 실패!");
			}
		} catch(Exception e) {
			System.out.println("delete 작업 중 오류가 발생했습니다. 데이터를 다시 확인해주세요.");
		}
		
	}

}