package entity;

import dto.PostRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private Long id;
    private String title;
    private String userName;
    private String password;
    private String content;

    public Post(PostRequestDto postRequestDto) {
        this.id = postRequestDto.getId();
        this.title = postRequestDto.getTitle();
        this.userName = postRequestDto.getUserName();
        this.password = postRequestDto.getPassword();
        this.content = postRequestDto.getContent();
    }
}
