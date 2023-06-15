package dto;

import lombok.Getter;

@Getter
public class PostRequestDto {

    private Long id;
    private String title;
    private String userName;
    private String password;
    private String content;

    public PostRequestDto(Long id, String title, String userName, String password, String content) {
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.password = password;
        this.content = content;
    }
}
