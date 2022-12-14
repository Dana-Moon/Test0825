package org.example.testAugust.constant;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");

    private String value;

    Role(String value) {
        this.value = value;
    }
}
