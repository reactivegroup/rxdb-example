package com.reactive.rxmysql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Mysql table mapper.
 */
@Slf4j
@Repository
public class MysqlTableMapper {

    @Autowired
    private DatabaseClient databaseClient;

    /**
     * Gets all.
     */
    public Flux<MysqlTableEntity> getAll() {
        // get all by flux result
        Flux<MysqlTableEntity> allFlux = databaseClient.execute("select * from mysql_table_entity")
                .as(MysqlTableEntity.class)
                .fetch()
                .all();

        // flux backpressure limit rate
        boolean streamBackpressure = false;
        if (streamBackpressure) {
            allFlux = allFlux.limitRate(1);
        }

        return allFlux;
    }

    /**
     * Insert.
     */
    public Mono<Integer> insert(MysqlTableEntity mysqlTableEntity) {
        // insert and return mono result
        Mono<Integer> insertMono = databaseClient.insert()
                .into(MysqlTableEntity.class)
                .using(mysqlTableEntity)
                .fetch()
                .rowsUpdated();

        // callback show insert id
        boolean showId = false;
        if (showId) {
            insertMono = insertMono.doOnSuccess(id -> {
                log.info("[MysqlTableMapper.insert] create id[{}]", id);
            });
        }

        return insertMono;
    }
}
