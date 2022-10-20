package dept.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dept.dao.Dao;
import dept.dao.MysqlDAO;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class SelectService extends Service {	
	public SelectService(Dao dao) {
		super(dao);
	}

	public List<Dept> select(){
		List<Dept> list = null;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			list = dao.select(conn);
			
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
		
		return list;
	}
}
