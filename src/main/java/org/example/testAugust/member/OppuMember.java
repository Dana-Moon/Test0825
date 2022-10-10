package org.example.testAugust.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class OppuMember {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(unique = true)
//    private String userId;
//
//    @Column(unique = true)
//    private String nickname;
//
//    private String password;
//
//    @Column(unique = true)
//    private String email;
//
//    private int accrueReportNumber;
//
//    private LocalDateTime recentLoginDate;
//
//    private String stopYN;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String nickname;

    private String password;

    @Column(unique = true)
    private String email;
}
