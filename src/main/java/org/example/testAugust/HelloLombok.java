package org.example.testAugust;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class HelloLombok {
    private final String hello;
    private final int lombok;

    public HelloLombok(String hello, int lombok) {
        this.hello = hello;
        this.lombok = lombok;
    }
}
