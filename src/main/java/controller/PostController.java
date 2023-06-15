package controller;

import dto.PostRequestDto;
import dto.PostResponseDto;
import org.springframework.web.bind.annotation.*;
import service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }
    @GetMapping("/posts/{id}")
    public PostResponseDto getPostOne(@PathVariable Long id){
        return postService.getPostOne(id);
    }

    @PostMapping("/posts")
    public PostResponseDto createPost(PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }

    @DeleteMapping("/posts/{id}")
    public Long deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }



}
