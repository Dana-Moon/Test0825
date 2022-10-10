package org.example.testAugust.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByTitle(String title);

    Board findByTitleAndContent(String title, String content);

    List<Board> findByTitleLike(String title);

    @Query(value = "select b from Board b where b.title like concat('%', :boardSearch, '%') ")
    List<Board> findBoardsByTitle(String boardSearch);

    Page<Board> findAll(Pageable pageable);
    //page에서 쿼리로 걸러서 검색에 날리면 된다.(검색 기능 할 때, 여기서 이미 걸러서 날리면 된다.)

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("update Board b set b.view = b.view+1 where b.id = :id")
//    int updateView(Long id);
}
