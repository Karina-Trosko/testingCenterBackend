package com.trosko_project.testingCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.trosko_project.testingCenter"})
@EntityScan(basePackages = {"com.trosko_project.testingCenter"})
public class TestingCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingCenterApplication.class, args);
	}

}
