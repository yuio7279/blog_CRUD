package com.sparta.post.dto;

import com.sparta.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class PostResponseDto {
    private Long id;
    private String title;
    private String userName;

    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String msg;

    public PostResponseDto(Post post) {
        this.id=  post.getId();
        this.title = post.getTitle();
        this.userName = post.getUserName();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}
