package com.example.backend;

import com.example.backend.entity.Admin;
import com.example.backend.entity.Book;
import com.example.backend.repository.AdminRepository;
import com.example.backend.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import static springfox.documentation.builders.PathSelectors.regex;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableSwagger2
public class BackendApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        ObjectMapper bMapper = new ObjectMapper();
        TypeReference<List<Book>> etypeReference = new TypeReference<List<Book>>(){};
        InputStream einputStream = TypeReference.class.getResourceAsStream("/json/books.json");
        List<Book> books = bMapper.readValue(einputStream,etypeReference);
        for (Book curr : books) {
            bookRepository.save(curr);
        }
        adminRepository.deleteAll();
        ObjectMapper aMapper = new ObjectMapper();
        TypeReference<List<Admin>> atypeReference = new TypeReference<List<Admin>>(){};
        InputStream ainputStream = TypeReference.class.getResourceAsStream("/json/admin.json");
        List<Admin> admins = aMapper.readValue(ainputStream,atypeReference);
        for (Admin curr : admins) {
            adminRepository.save(curr);
        }

    }
    @Bean
    public Docket bookApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("spring-swagger-api")
                .apiInfo(apiInfo())
                .select()
                .paths(regex ("/api/books.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Books with Swagger")
                .description("Spring REST Book with Swagger")
                .license("Apache License Version 2.0")
                .licenseUrl("")
                .version("1.0")
                .build();
    }


}
