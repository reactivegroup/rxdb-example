package com.reactive.rxmysql;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestBootstrap {

    @Test
    void init() {
        log.info("[TestBootstrap] start...");
    }
}