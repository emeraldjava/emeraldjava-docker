package io.github.emeraldjava.docker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
public class DbConnectorApplication implements ApplicationRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("DbConnectorApplication");
        try {
            jdbcTemplate.execute("SELECT * FROM TABLE");
        } catch(DataAccessException e) {
            log.error("",e);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DbConnectorApplication.class, args);
    }
}
