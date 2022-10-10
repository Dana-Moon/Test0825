package org.example.testAugust.admin;

import lombok.Getter;
import lombok.Setter;
import org.example.testAugust.constant.Role;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String adminId;

    @Column(unique = true)
    private String adminNickname;

    private String password;

    @Column(unique = true)
    private String email;

}
