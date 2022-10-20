package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.dao.Dao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class UpdateService extends Service {
	public UpdateService(Dao dao) {
		super(dao);
	}

	public int update(Dept dept) {
		
		int result = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			result = dao.update(conn, dept);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}

}