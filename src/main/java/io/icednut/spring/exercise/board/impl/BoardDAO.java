package io.icednut.spring.exercise.board.impl;

import io.icednut.spring.exercise.board.BoardDTO;
import io.icednut.spring.exercise.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("boardDAO")
public class BoardDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL 명령어들
    private final String BOARD_CREATE = "CREATE TABLE BOARD(SEQ NUMBER(5) PRIMARY KEY, TITLE VARCHAR2(200), WRITER VARCHAR2(20), CONTENT VARCHAR2(2000), REGDATE DATE DEFAULT SYSDATE, CNT NUMBER(5) DEFAULT 0);";
    private final String BOARD_INSERT =
            "insert into BOARD(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set title=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete BOARD where seq=?";
    private final String BOARD_GET = "select * from BOARD where seq=?";
    private final String BOARD_LIST = "select * from BOARD order by seq desc";

    // 테이블 생성
    public void createBoard() {
        System.out.println("===> JDBC로 createBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_CREATE);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // CRUD 기능 메소드 구현
    // 글 등록
    public void insertBoard(BoardDTO dto) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, dto.getTitle());
            stmt.setString(2, dto.getWriter());
            stmt.setString(3, dto.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 수정
    public void updateBoard(BoardDTO dto) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, dto.getTitle());
            stmt.setString(2, dto.getContent());
            stmt.setInt(3, dto.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 삭제
    public void deleteBoard(BoardDTO dto) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, dto.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 상세 조회
    public BoardDTO getBoard(BoardDTO dto) {
        System.out.println("===> JDBC로 getBoard() 기능 처리");
        BoardDTO board = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, dto.getSeq());
            rs = stmt.executeQuery();
            if (rs.next()) {
                board = new BoardDTO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return board;
    }

    // 글 목록 조회
    public List<BoardDTO> getBoardList(BoardDTO dto) {
        System.out.println("===> JDBC로 getBoardList() 기능 처리");
        List<BoardDTO> boardList = new ArrayList<BoardDTO>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return boardList;
    }
}
