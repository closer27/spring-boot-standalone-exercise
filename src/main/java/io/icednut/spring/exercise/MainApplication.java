package io.icednut.spring.exercise;

import io.icednut.spring.exercise.board.BoardDTO;
import io.icednut.spring.exercise.board.BoardService;
import io.icednut.spring.exercise.model.Tv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@SpringBootApplication
@ImportResource({"applicationContext.xml"})
public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);

        BoardService boardService = (BoardService) applicationContext.getBean("boardService");
        boardService.createBoard();

        BoardDTO dto = new BoardDTO();
        dto.setTitle("임시 제목");
        dto.setWriter("홍길동");
        dto.setContent("임시 내용..................");
        boardService.insertBoard(dto);

        List<BoardDTO> boardList = boardService.getBoardList(dto);
        for (BoardDTO board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }
}
