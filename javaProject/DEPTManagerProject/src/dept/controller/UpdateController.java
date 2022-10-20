package dept.controller;

import dept.Main;
import dept.dao.MysqlDAO;
import dept.domain.Dept;
import dept.service.UpdateService;

public class UpdateController implements Controller {
	
	UpdateService service = new UpdateService(new MysqlDAO());
	
	public void process() {
		try {
			System.out.println("수정할 부서 데이터를 입력합니다.");
			System.out.println("부서번호 >>");
			int deptno = Integer.parseInt(Main.sc.nextLine());
			System.out.println("부서이름 >>");
			String dname = Main.sc.nextLine();
			System.out.println("부서위치 >>");
			String loc = Main.sc.nextLine();
			
			int result = service.update(new Dept(deptno, dname, loc));
			
			if(result>0) {
				System.out.println("수정되었습니다.");
			} else {
				System.out.println("수정 실패!");
			}
		} catch(Exception e) {
			System.out.println("update 작업 중 오류가 발생했습니다. 데이터를 다시 확인해주세요.");
		}
		
	}

}