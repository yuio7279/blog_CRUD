package repository;

import dto.PostRequestDto;
import dto.PostResponseDto;
import entity.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {

    Map<Long, Post> store = new HashMap<>();

    public PostResponseDto save(Post post){
        if(store.size() > 0){
            store.put(post.getId()+1L,post);
        }else{
            store.put(1L,post);
        }
        //dto 변환
        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;
    }


}
