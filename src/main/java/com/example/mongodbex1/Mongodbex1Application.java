package com.example.mongodbex1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.mongodbex1.util.ModelMapperConvertor;

@SpringBootApplication
@EnableMongoRepositories
public class Mongodbex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mongodbex1Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@Bean
	ModelMapperConvertor getModelMapperConvertor() {
		return new ModelMapperConvertor();
	}
}
