package org.example.testAugust.member;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

//    OppuMember insertMember(String userId, String nickname, String password, String email);
    OppuMember insertMember(String username, String nickname, String email, String password);

    OppuMember getMember(String username);
}