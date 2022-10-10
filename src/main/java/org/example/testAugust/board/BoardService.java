package org.example.testAugust.board;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {


    //게시글 리스트 불러오기
//    public List<Board> getList();

    Board getBoardRequest(Long id);

    void insertBoard(String category, String title, String nickname, String content);

//    public List<Board> searchEmail(String boardSearch);


    Page<Board> getList(int page);

//    int updateView(Long id);
}
