package dto;

import lombok.Getter;

@Getter
public class PostRequestDto {

    private Long id;
    private String title;
    private String userName;
    private String password;
    private String content;

}
