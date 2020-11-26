package com.lujiatao.c07;

import java.util.List;
import java.util.stream.Stream;

import static com.lujiatao.c07.Calculator.add;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJAssertion {

    public static void main(String[] args) {
        assertThat(add(1, 1)).isEqualTo(2);
        assertThat(add(1, 1)).isNotEqualTo(3);
        List<String> actual = asList("张三", "李四", "王五");
        assertThat(actual).hasSize(3)
                .contains("张三", "李四")
                .doesNotContain("小明");
        List<Integer> actual2 = asList(1, 80, 0, 55, 12, 6);
        assertThat(actual2).filteredOn(Filtertor::lessThanTen)
                .containsOnly(1, 0, 6);
        Stream<Integer> actual3 = Stream.of(1, 80, 0, 55, 12, 6);
        assertThat(actual3).filteredOn(Filtertor::lessThanTen)
                .containsOnly(1, 0, 6);
    }

}
