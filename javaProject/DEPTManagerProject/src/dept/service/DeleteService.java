package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.dao.Dao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class DeleteService extends Service {
	public DeleteService(Dao dao) {
		super(dao);
	}

	public int delete(int deptno) {
		
		int result = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			result = dao.delete(conn, deptno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}

}