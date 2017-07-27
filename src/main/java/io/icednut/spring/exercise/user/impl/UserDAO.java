package io.icednut.spring.exercise.user.impl;

import io.icednut.spring.exercise.common.JDBCUtil;
import io.icednut.spring.exercise.user.UserDTO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository("userDAO")
public class UserDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL 명령어들
    private final String USER_CREATE = "CREATE TABLE USER(ID VARCHAR2(8) PRIMARY KEY, PASSWORD VARCHAR2(8), NAME VARCHAR2(20), ROLE VARCHAR2(5));";
    private final String USER_GET = "select * from users where id=? and password=?";

    // 테이블 생성
    public void createUser() {
        System.out.println("===> JDBC로 createUser() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_CREATE);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 상세 조회
    public UserDTO getUser(UserDTO dto) {
        System.out.println("===> JDBC로 getUser() 기능 처리");
        UserDTO user = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, dto.getId());
            stmt.setString(2, dto.getPassword());
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserDTO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
}