package com.salesken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class StudentsReportAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(StudentsReportAppApplication.class, args);
	}

}
