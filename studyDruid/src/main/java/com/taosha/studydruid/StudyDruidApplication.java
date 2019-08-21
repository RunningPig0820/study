package com.taosha.studydruid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangmin
 */
@SpringBootApplication
@MapperScan("com.taosha.studydruid.dao")
public class StudyDruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyDruidApplication.class, args);
	}

}
