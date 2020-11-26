package com.lujiatao.c07;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class StringLengthLessThanTen extends BaseMatcher<String> {

    @Override
    public boolean matches(Object actual) {
        if (actual instanceof String) {
            String str = String.valueOf(actual);
            return str.length() < 10;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("字符串长度小于10！");
    }

    public static Matcher<String> stringLengthLessThanTen() {
        return new StringLengthLessThanTen();
    }

}
