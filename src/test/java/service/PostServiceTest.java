package service;

import dto.PostRequestDto;
import dto.PostResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.PostRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostServiceTest {

    @Test
    void getPosts() {
        //given
        PostService postService = new PostService(new PostRepository());
        postService.createPost(new PostRequestDto(1L, "title", "유저네임", "1234", "content"));
        postService.createPost(new PostRequestDto(2L, "title2", "유저네임2", "1234", "content2"));

        //when
        List<PostResponseDto> posts = postService.getPosts();

        //then
        Assertions.assertThat(posts.size()).isEqualTo(2);

    }

    @Test
    void createPost() {
        PostService postService = new PostService(new PostRepository());

        PostResponseDto post = postService.createPost(new PostRequestDto(1L, "title", "유저네임", "1234", "content"));

        Assertions.assertThat(post.getId()).isEqualTo(1L);
    }

    @Test
    void getPostOne(){
        PostService postService = new PostService(new PostRepository());
        postService.createPost(new PostRequestDto(1L, "title", "유저네임", "1234", "content"));
        postService.createPost(new PostRequestDto(2L, "title2", "유저네임2", "1234", "content2"));
        Long id = 2L;

        PostResponseDto postOne = postService.getPostOne(id);

        Assertions.assertThat(postOne.getId()).isEqualTo(id);
    }

    @Test
    void deletePost(){
        PostService postService = new PostService(new PostRepository());
        postService.createPost(new PostRequestDto(1L, "title", "유저네임", "1234", "content"));
        postService.createPost(new PostRequestDto(2L, "title2", "유저네임2", "1234", "content2"));
        Long id = 2L;

        Long deleteId = postService.deletePost(id);

        Assertions.assertThat(deleteId).isEqualTo(2L);
    }
}