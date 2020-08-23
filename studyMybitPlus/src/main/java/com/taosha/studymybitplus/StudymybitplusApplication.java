package com.taosha.studymybitplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class StudymybitplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudymybitplusApplication.class, args);
	}

}
