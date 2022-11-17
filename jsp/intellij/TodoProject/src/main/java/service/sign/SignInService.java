package service.sign;

import dao.SignDao;
import module.Member;
import util.ConnectionUtil;

import java.sql.Connection;

public class SignInService {
    SignDao dao = new SignDao();

    public boolean signInByIdPwService(String id, String password) throws Exception {
        Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.signIn(conn, id, password);
    }


    public Member signInByUUID(String uuid) throws Exception {
        Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.signInByUUID(conn, uuid);
    }

    public void updateUUIDByIdx(String uuid, long idx) throws Exception {
        Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.updateUUIDByIdx(conn, idx, uuid);
    }
}
