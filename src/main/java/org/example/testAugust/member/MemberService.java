package org.example.testAugust.member;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.SecurityConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

//    public OppuMember insertMember(String userId, String nickname, String password, String email, int accrueReportNumber, LocalDateTime recentLoginDate, String stopYN) { return null;}

    public void insertMember(String userId, String nickname, String password, String email){
        OppuMember oppuMember = new OppuMember();
        oppuMember.setUserId(userId);
        oppuMember.setNickname(nickname);
        oppuMember.setPassword(passwordEncoder.encode(password));
        oppuMember.setEmail(email);
        this.memberRepository.save(oppuMember);
    }
}
