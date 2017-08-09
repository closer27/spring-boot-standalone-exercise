package io.icednut.spring.exercise.board.impl;

import io.icednut.spring.exercise.board.BoardDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardDTO> {
    public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardDTO board = new BoardDTO();
        board.setSeq(rs.getInt("SEQ"));
        board.setTitle(rs.getString("TITLE"));
        board.setWriter(rs.getString("WRITER"));
        board.setContent(rs.getString("CONTENT"));
        board.setRegDate(rs.getDate("REGDATE"));
        board.setCnt(rs.getInt("CNT"));
        return board;
    }
}
