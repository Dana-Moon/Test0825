package org.example.testAugust.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<OppuMember, Long> {
//    Optional<OppuMember> findByUserId(String userId);
    Optional<OppuMember> findByUsername(String username);
}


