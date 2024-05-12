package com.example.demo;

import com.example.demo.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoRestTemplateApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoRestTemplateApplication.class, args);

        User userJames = new User(3L,"James","Brown",(byte)29);
        User userThomas = new User(3L,"Thomas","Shelby",(byte)29);
        Communication communication = new Communication(getRestTemplate(), getHttp());
        communication.listUser();
        communication.addUser(userJames);
        communication.changeUser(userThomas);
        communication.deleteUser(3);


    }

    @Bean
    static public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    static public HttpHeaders getHttp() {
        return new HttpHeaders();
    }

}
