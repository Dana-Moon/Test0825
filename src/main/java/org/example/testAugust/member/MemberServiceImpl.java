package org.example.testAugust.member;

import lombok.RequiredArgsConstructor;
import org.example.testAugust.DataNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

//    public OppuMember insertMember(String userId, String nickname, String password, String email, int accrueReportNumber, LocalDateTime recentLoginDate, String stopYN) { return null;}

//    public OppuMember insertMember(String userId, String nickname, String password, String email){
//        OppuMember oppuMember = new OppuMember();
//        oppuMember.setUserId(userId);
//        oppuMember.setNickname(nickname);
//        oppuMember.setPassword(passwordEncoder.encode(password));
//        oppuMember.setEmail(email);
//        this.memberRepository.save(oppuMember);
//        return oppuMember;
//    }

    public OppuMember insertMember(String username, String nickname, String email, String password) {
        OppuMember member = new OppuMember();
        member.setUsername(username);
        member.setNickname(nickname);
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member);
        return member;
    }

    public OppuMember getMember(String username) {
        Optional<OppuMember> member = this.memberRepository.findByUsername(username);
        if (member.isPresent()) {
            return member.get();
        } else {
            throw new DataNotFoundException("oppumember not found");
        }
    }
}
