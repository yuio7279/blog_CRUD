package service;

import dto.PostRequestDto;
import dto.PostResponseDto;
import entity.Post;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import repository.PostRepository;

import java.util.List;

@Service
@NoArgsConstructor
public class PostService {

    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponseDto> getPosts(){
        return postRepository.findAll();

    }
    public PostResponseDto createPost(PostRequestDto postRequestDto){
        //Entity로 변환
        Post post = new Post(postRequestDto);

        return postRepository.save(post);
    }

    public PostResponseDto getPostOne(Long id){
        return postRepository.findById(id);
    }

    public Long deletePost(Long id,String password){
        return postRepository.delete(id,password);
    }

    public Long updatePost(Long id, PostRequestDto postRequestDto){
        Post post = new Post(postRequestDto);

        return postRepository.update(id, post);
    }
}
