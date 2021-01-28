package com.reactive.rxmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Mysql Rest controller.
 */
@RestController
public class MysqlController {

    @Autowired
    private MysqlTableMapper mysqlTableMapper;

    /**
     * Query all entities.
     */
    @GetMapping("/entity")
    public Flux<MysqlTableEntity> queryAll() {
        Flux<MysqlTableEntity> entityFlux = mysqlTableMapper.getAll();
        return entityFlux;
    }

    /**
     * Create entity.
     *
     * @param entity the entity
     */
    @PostMapping("/entity")
    public Mono<MysqlTableEntity> create(@RequestBody MysqlTableEntity entity) {
        Mono<Integer> idMono = mysqlTableMapper.insert(entity);
        Mono<MysqlTableEntity> result = idMono.map(id -> {
            entity.setId(id);
            return entity;
        });
        return result;
    }
}
