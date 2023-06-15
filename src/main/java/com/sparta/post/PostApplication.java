package com.sparta.post;

import dto.PostRequestDto;
import dto.PostResponseDto;
import entity.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.PostRepository;
import service.PostService;

@SpringBootApplication
public class PostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class, args);

    }

}
