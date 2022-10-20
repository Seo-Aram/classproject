package dept.controller;

import java.util.List;

import dept.dao.MysqlDAO;
import dept.domain.Dept;
import dept.service.SelectService;

public class SelectController implements Controller {
	SelectService service = new SelectService(new MysqlDAO());
	
	public void process() {
		List<Dept> list = service.select();
		
		if(list != null && !list.isEmpty()) {
			for(Dept d : list) {
				System.out.println(d);
			}
		} else {
			System.out.println("검색 결과 없음!");
		}
	}
}
