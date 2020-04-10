package org.csu.fastfish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("org.csu.fastfish")
public class FastfishApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastfishApplication.class, args);
    }

}
