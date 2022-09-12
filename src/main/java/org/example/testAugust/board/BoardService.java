package org.example.testAugust.board;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.DataNotFoundException;
import org.example.testAugust.board.Board;
import org.example.testAugust.board.BoardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getList() {
        return this.boardRepository.findAll();
    }

    public Optional<Board> getBoard(Board board) {
        return boardRepository.findById(board.getId());
    }

    public Board getBoardRequest(Long id) {
        Optional<Board> question = this.boardRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question noe found");
        }
    }

    public void insertBoard(String category, String title, String nickname, String content) {
        Board board = new Board();
        board.setCategory(category);
        board.setTitle(title);
        board.setNickname(nickname);
        board.setContent(content);
        board.setCreateDate(LocalDateTime.now());
        this.boardRepository.save(board);
    }
}
