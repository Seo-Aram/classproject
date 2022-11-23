package com.todo.service.sign;

import com.todo.dao.SignDao;
import com.todo.module.sign.Member;
import com.todo.module.sign.MemberRegRequest;
import com.todo.util.ConfigUtil;
import com.todo.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;

@Log4j2
@Service
public class SignService {
    @Autowired
    private SignDao dao;

    public Member signInByIdPw(String id, String pw) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.signInByIdPw(conn, id, pw);
    }

    public Member signInByUUID(String uuid) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.signInByUUID(conn, uuid);
    }

    public void updateProfileUrl(String url, String userId) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.updateProfileImg(conn, url, userId);
    }

    public void updateUUID(String uuid, String userId) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        dao.updateUUID(conn, uuid, userId);
    }

    public int signUp(MemberRegRequest regRequest, HttpServletRequest request) throws Exception {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int successCnt = dao.signUp(conn, regRequest.toMember());

        if(successCnt > 0
                && regRequest.getProfileImg() != null
                && !regRequest.getProfileImg().isEmpty()
                && regRequest.getProfileImg().getSize() > 0) {

            String uploadURI = (String)ConfigUtil.getConfig("uploadURI");
            String dirPath = (String)ConfigUtil.getConfig("fileSaveDir");
            //String dirPath = request.getSession().getServletContext().getRealPath(uploadURI);
            String newFileName = System.nanoTime() + regRequest.getProfileImg().getOriginalFilename();

            log.info(dirPath);

            regRequest.getProfileImg().transferTo(
                    new File(dirPath, newFileName)
            );

            dao.updateProfileImg(conn, newFileName, regRequest.getUserId());

        }

        return 0; // dao.signUp(conn, member);
    }
}
