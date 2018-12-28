package com.goldmantis.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
//@MapperScan(basePackages = "com.springboot.mybatis.dao.user1")
public class SpringBootApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationMain.class, args);
	}
}
