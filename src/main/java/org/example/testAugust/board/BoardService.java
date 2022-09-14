package org.example.testAugust.board;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
            throw new DataNotFoundException("question not found");
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

    public List<Board> searchEmail(String boardSearch) {
        return this.boardRepository.findBoardsByTitle(boardSearch);
    }

    public Page<Board> getList(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.boardRepository.findAll(pageable);
    }
}
