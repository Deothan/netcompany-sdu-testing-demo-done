package com.netcompany.sdu.testing.testingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.netcompany.sdu.testing.testingdemo.service", "com.netcompany.sdu.testing.testingdemo.controller"})
public class TestingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingDemoApplication.class, args);
	}
}