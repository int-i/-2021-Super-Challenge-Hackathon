package inti.SAhomepage.Board.service;

import inti.SAhomepage.Board.domain.entity.Board;
import inti.SAhomepage.Board.domain.repository.BoardRepository;
import inti.SAhomepage.Board.dto.BoardDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boardList){
            BoardDto boardDto = new BoardDto
                    .Builder(board.getId(), board.getAuthor(), board.getTitle(), board.getContent(), board.getFileId(), board.getCreatedDate(), board.getModifiedDate())
                    .build();
            boardDtoList.add(boardDto);

        }
        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long id){
        Board board = boardRepository.findById(id).get();

        BoardDto boardDto = new BoardDto
                .Builder(board.getId(), board.getAuthor(), board.getTitle(), board.getContent(), board.getFileId(), board.getCreatedDate(), board.getModifiedDate())
                .build();
        return boardDto;
    }

    @Transactional
    public void deletePost(Long id){
        boardRepository.deleteById(id);
    }
}
