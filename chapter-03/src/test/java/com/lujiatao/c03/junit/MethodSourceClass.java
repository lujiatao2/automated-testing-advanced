package com.lujiatao.c03.junit;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MethodSourceClass {

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("http://localhost:9002/login", "zhangsan", "zhangsan123456"),
                Arguments.of("http://localhost:9002/login", "lisi", "lisi123456")
        );
    }

}
