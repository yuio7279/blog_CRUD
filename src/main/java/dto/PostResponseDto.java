package dto;

import entity.Post;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter

public class PostResponseDto {
    private Long id;
    private String title;
    private String userName;

    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.id=  post.getId();
        this.title = post.getTitle();
        this.userName = post.getUserName();
        this.content = post.getUserName();
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }
}
