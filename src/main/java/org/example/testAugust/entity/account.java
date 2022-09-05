package org.example.testAugust.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class account {
    @Id
    @GeneratedValue
    private Long seq;
}
