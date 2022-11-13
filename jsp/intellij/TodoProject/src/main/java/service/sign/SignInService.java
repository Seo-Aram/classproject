package service.sign;

import controller.dao.SignDao;
import util.ConnectionUtil;

import java.sql.Connection;

public class SignInService {
    SignDao dao = new SignDao();

    public boolean signInService(String id, String password) throws Exception {
        Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.signIn(conn, id, password);
    }
}
