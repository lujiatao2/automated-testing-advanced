package com.lujiatao.c07;

import static com.lujiatao.c07.Calculator.add;
import static com.lujiatao.c07.StringLengthLessThanTen.stringLengthLessThanTen;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HamcrestAssertion {

    public static void main(String[] args) {
        assertThat(add(1, 1), equalTo(2));
        assertThat("Hello World!", stringLengthLessThanTen());
    }

}
