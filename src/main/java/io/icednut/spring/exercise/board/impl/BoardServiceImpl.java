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
    public void createBoard() { boardDAO.createBoard(); }

    @Override
    public void insertBoard(BoardDTO dto) {
//        if(dto.getSeq() == 0) {
//            throw new IllegalArgumentException("0번 글은 등록할 수 없습니다");
//        }
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
