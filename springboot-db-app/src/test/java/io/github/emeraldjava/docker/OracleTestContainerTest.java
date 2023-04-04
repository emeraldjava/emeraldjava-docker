package io.github.emeraldjava.docker;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;

/**
 * OracleTestContainerTest
 * https://trangelier.dev/spring-boot-testcontainers-oracle-xe/
 * https://fullstackcode.dev/2022/07/17/integration-testing-with-spring-boottestcontainersoracle/
 */
@SpringBootTest
@Testcontainers
@Import(OracleTestContainerTest.OracleDbConfiguration.class)
@ActiveProfiles("oracle")
@Slf4j
public class OracleTestContainerTest {

//    @Autowired
//    MyService service;
//    @Autowired
//    MyRepository repository;

    @TestConfiguration
    public class OracleDbConfiguration {
        @Bean
        DataSource dataSource() {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl(oracle.getJdbcUrl());
            hikariConfig.setUsername(oracle.getUsername());
            hikariConfig.setPassword(oracle.getPassword());
            return new HikariDataSource(hikariConfig);
        }
    }

    @Container
    static final OracleContainer oracle = new OracleContainer("gvenzl/oracle-xe:18.4.0-slim").withEnv("ORACLE_PASSWORD", "oracle");

    @Test
    public void myFancyTest(){
        assertNotNull(oracle);
//        assertThat(repository.findAll().size()).isEqualTo(0);
    }
}
