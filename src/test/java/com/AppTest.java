package com;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    @DisplayName("WiseSayings Test")
    void t1() {
        String rs = AppTestRunner.run("종료");

        assertThat(rs)
                .contains("== 명언 앱 ==");
    }
}