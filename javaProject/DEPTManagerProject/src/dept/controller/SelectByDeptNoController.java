package dept.controller;

import dept.Main;
import dept.dao.MysqlDAO;
import dept.domain.Dept;
import dept.service.SelectByDeptNoService;

public class SelectByDeptNoController implements Controller {
	SelectByDeptNoService service = new SelectByDeptNoService(new MysqlDAO());
	
	public void process() {
		try {
			System.out.println("검색할 부서 번호를 입력해주세요.");
			System.out.println("부서번호 >>");
			int deptno = Integer.parseInt(Main.sc.nextLine());
			
			Dept data= service.selectByDeptNo(deptno);
			
			if(data != null) {
				System.out.println(data);
			} else {
				System.out.println("검색 결과 없음!");
			}
		} catch(Exception e) {
			System.out.println("select 작업 중 오류가 발생했습니다. 데이터를 다시 확인해주세요.");
		}
	}
}
