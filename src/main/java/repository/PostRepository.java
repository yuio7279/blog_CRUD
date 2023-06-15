package repository;

import dto.PostRequestDto;
import dto.PostResponseDto;
import entity.Post;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {

    Map<Long, Post> store = new HashMap<>();

    public PostResponseDto save(Post post){

        Long maxId = store.size() > 0? Collections.max(store.keySet())+1 : 1;
        post.setId(maxId);
        store.put(post.getId(),post);
        //dto 변환
        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;
    }

    public List<PostResponseDto> findAll(){
        return store.values().stream().map(PostResponseDto::new).toList();

    }

    public PostResponseDto findById(Long id){
        if(store.get(id) != null){
            Post post = store.get(id);
            PostResponseDto postResponseDto = new PostResponseDto(post);
            return postResponseDto;
        }else {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
    }

}
