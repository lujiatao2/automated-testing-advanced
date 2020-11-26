package com.lujiatao.c03.junit;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ArgumentsProviderClass implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("http://localhost:9002/login", "zhangsan", "zhangsan123456"),
                Arguments.of("http://localhost:9002/login", "lisi", "lisi123456")
        );
    }

}
