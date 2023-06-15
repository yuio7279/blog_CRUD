package service;

import dto.PostRequestDto;
import dto.PostResponseDto;
import entity.Post;
import org.springframework.stereotype.Service;
import repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

//    public List<PostResponseDto> getPosts(){
//        if(postRepository.getPosts() != null){
//            return postRepository.getPosts();
//        }else{
//            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
//        }
//    }
    public PostResponseDto createPost(PostRequestDto postRequestDto){
        //Entity로 변환
        Post post = new Post(postRequestDto);

        return postRepository.save(post);
    }
}
