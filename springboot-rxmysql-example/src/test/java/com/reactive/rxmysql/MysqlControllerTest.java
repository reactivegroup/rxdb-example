package com.reactive.rxmysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MysqlControllerTest extends TestBootstrap {

    @Autowired
    private MysqlController mysqlController;

    @Test
    void queryAll() {
        Flux<MysqlTableEntity> flux = mysqlController.queryAll();
        List<MysqlTableEntity> block = flux.collectList().block();
        if (!CollectionUtils.isEmpty(block)) {
            MysqlTableEntity mysqlTableEntity = block.get(0);
            assertNotNull(mysqlTableEntity.getId());
        }
    }

    @Test
    void create() {
        MysqlTableEntity entity = new MysqlTableEntity();
        entity.setName("test" + System.currentTimeMillis());
        Mono<MysqlTableEntity> mono = mysqlController.create(entity);
        MysqlTableEntity mysqlTableEntity = mono.block();
        assertNotNull(mysqlTableEntity.getId());
    }
}