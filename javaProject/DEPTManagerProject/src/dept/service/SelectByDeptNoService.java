package dept.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dept.dao.Dao;
import dept.dao.MysqlDAO;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class SelectByDeptNoService extends Service {	
	public SelectByDeptNoService(Dao dao) {
		super(dao);
	}

	public Dept selectByDeptNo(int deptno){
		Dept data = null;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			data = dao.selectByDeptno(conn, deptno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return data;
	}
}
