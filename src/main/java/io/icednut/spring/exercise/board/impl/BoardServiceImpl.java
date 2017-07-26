package io.icednut.spring.exercise.board.impl;

import io.icednut.spring.exercise.board.BoardDTO;
import io.icednut.spring.exercise.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO boardDAO;

    @Override
    public void insertBoard(BoardDTO dto) {
        boardDAO.insertBoard(dto);
    }

    @Override
    public void updateBoard(BoardDTO dto) {
        boardDAO.updateBoard(dto);
    }

    @Override
    public void deleteBoard(BoardDTO dto) {
        boardDAO.deleteBoard(dto);
    }

    @Override
    public BoardDTO getBoard(BoardDTO dto) {
        return boardDAO.getBoard(dto);
    }

    @Override
    public List<BoardDTO> getBoardList(BoardDTO dto) {
        return boardDAO.getBoardList(dto);
    }
}