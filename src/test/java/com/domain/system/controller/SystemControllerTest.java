package com.domain.system.controller;

import com.AppTestRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemControllerTest {
    @Test
    @DisplayName("WiseSayings Test")
    void t1() {
        String rs = AppTestRunner.run("");

        assertThat(rs)
                .contains("프로그램이 종료되었습니다.");
    }
}
