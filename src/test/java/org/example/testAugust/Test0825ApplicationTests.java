package org.example.testAugust;

import org.example.testAugust.board.BoardService;
import org.example.testAugust.reply.Reply;
import org.example.testAugust.board.Board;
import org.example.testAugust.reply.ReplyRepository;
import org.example.testAugust.board.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Test0825ApplicationTests {
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Autowired
//    private BoardService boardService;
//
//    @Autowired
//    private ReplyRepository replyRepository;
//
//    @Test
//    void testJpaQ() {
//        Board q1 = new Board();
//        q1.setNickname("연습용회원1번");
//        q1.setTitle("이것은 연습용 제목입니다");
//        q1.setContent("제목짓기는 너무 쉽습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.boardRepository.save(q1);
//
//        Board q2 = new Board();
//        q2.setNickname("연습용회원2번");
//        q2.setTitle("제목으로 링크가 이어집니다.");
//        q2.setContent("할 게 많군요.");
//        q2.setCreateDate(LocalDateTime.now());
//        this.boardRepository.save(q2);
//
//        List<Board> all = this.boardRepository.findAll();
//        System.out.println("-------------------------");
//        assertEquals(2,all.size());
//
//        Board q = all.get(0);
//        System.out.println("-------------------------");
//        assertEquals("sbb가 무엇인가요?", q.getTitle());
//    }
//
//    @Test
//    void testFindByID() {
//        Optional<Board> oq = this.boardRepository.findById(1L);
//        if (oq.isPresent()) {
//            Board q = oq.get();
//            assertEquals("sbb가 무엇인가요?", q.getTitle());
//        }
//    }
//
//    @Test
//    void testFindByTitle() {
//        Board q = this.boardRepository.findByTitle("sbb가 무엇인가요?");
//        assertEquals(1, q.getId());
//    }
//
//
//    @Test
//    void testFindByTitleAndContent() {
//        Board q = this.boardRepository.findByTitleAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//        assertEquals(1, q.getId());
//    }
//
//    @Test
//    void testFindByTitleLke() {
//        List<Board> qList = this.boardRepository.findByTitleLike("sbb%");
//        Board q = qList.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getTitle());
//    }
//
//    @Test
//    void testChangeQuestion() {
//        Optional<Board> oq = this.boardRepository.findById(1L);
//        assertTrue(oq.isPresent());
//        Board q = oq.get();
//        q.setTitle("수정된 제목");
//        this.boardRepository.save(q);
//    }
//
//    @Test
//    void testDeleteQuestion() {
//        assertEquals(2, this.boardRepository.count());
//        Optional<Board> oq = this.boardRepository.findById(1L);
//        assertTrue(oq.isPresent());
//        Board q = oq.get();
//        this.boardRepository.delete(q);
//        assertEquals(1, this.boardRepository.count());
//    }
//
//    @Test
//    void testAnswer() {
//        Optional<Board> ob = this.boardRepository.findById(2L);
//        assertTrue(ob.isPresent());
//        Board b = ob.get();
//
//        Reply a = new Reply();
//        a.setContent("자동으로 생성됩니다.");
//        a.setBoard(b);
//        a.setCreateDate(LocalDateTime.now());
//        this.replyRepository.save(a);
//    }
//
//    @Test
//    void testAnswerFindById() {
//        Optional<Reply> oa = this.replyRepository.findById(1L);
//        assertTrue(oa.isPresent());
//        Reply a = oa.get();
//        assertEquals(2, a.getBoard().getId());
//    }
//
//    @Transactional
//    @Test
//    void testFindQuestion() {
//        Optional<Board> oq = this.boardRepository.findById(2L);
//        assertTrue(oq.isPresent());
//        Board q = oq.get();
//
//        List<Reply> replyList = q.getReplyList();
//
//        assertEquals(1, replyList.size());
//        assertEquals("자동으로 생성됩니다.", replyList.get(0).getContent());
//    }
//
//    @Test
//    void testJpa() {
//        for(int i=1; i <= 20; i++) {
//            String category = "test";
//            String title = String.format("테스트 데이터입니다. : [%03d]", i);
//            String nickname = "";
//            String content = "테스트 내용";
//            this.boardService.insertBoard(category, title, nickname, content);
//        }
//    }
}
