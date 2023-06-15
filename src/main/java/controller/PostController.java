package controller;

import dto.PostRequestDto;
import dto.PostResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @GetMapping("/posts")
//    public List<PostResponseDto> getPosts(){
//        return postService.getPosts();
//    }

    @PostMapping("/posts")
    public PostResponseDto createPost(PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }

}
