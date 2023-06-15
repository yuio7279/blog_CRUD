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


}
