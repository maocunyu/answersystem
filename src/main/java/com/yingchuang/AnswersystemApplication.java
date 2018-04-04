package com.yingchuang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yingchuang.dao")
@SpringBootApplication
public class AnswersystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnswersystemApplication.class, args);



	}
}
