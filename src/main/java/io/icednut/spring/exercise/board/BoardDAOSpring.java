package io.icednut.spring.exercise.board;

import io.icednut.spring.exercise.board.impl.BoardRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// DA(Data Access Object)
@Repository
public class BoardDAOSpring {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String BOARD_CREATE = "CREATE TABLE BOARD(SEQ NUMBER(5) PRIMARY KEY, TITLE VARCHAR2(200), WRITER VARCHAR2(20), CONTENT VARCHAR2(2000), REGDATE DATE DEFAULT SYSDATE, CNT NUMBER(5) DEFAULT 0);";
    private final String BOARD_INSERT =
            "insert into BOARD(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set title=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete BOARD where seq=?";
    private final String BOARD_GET = "select * from BOARD where seq=?";
    private final String BOARD_LIST = "select * from BOARD order by seq desc";

    public void createBoard() {
        System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
        jdbcTemplate.update(BOARD_CREATE);
    }

    public void insertBoard(BoardDTO dto) {
        System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
        jdbcTemplate.update(BOARD_UPDATE, dto.getTitle(), dto.getContent(), dto.getSeq());
    }

    public void updateBoard(BoardDTO dto) {
        System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
        jdbcTemplate.update(BOARD_UPDATE, dto.getTitle(), dto.getContent(), dto.getSeq());
    }

    public void deleteBoard(BoardDTO dto) {
        System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
        jdbcTemplate.update(BOARD_DELETE, dto.getSeq());
    }

    public BoardDTO getBoard(BoardDTO dto) {
        System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
        Object[] args = {dto.getSeq()};
        return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
    }

    public List<BoardDTO> getBoardList(BoardDTO dto) {
        System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
        return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
    }
}
