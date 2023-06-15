package repository;

import dto.PostRequestDto;
import dto.PostResponseDto;
import entity.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepository {

    Map<Long, Post> store = new HashMap<>();

    public PostResponseDto save(Post post) {

        Long maxId = store.size() > 0 ? Collections.max(store.keySet()) + 1 : 1;
        post.setId(maxId);
        store.put(post.getId(), post);
        //dto 변환
        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;
    }

    public List<Post> findAll() {
        return store.values().stream().toList();

    }

    public PostResponseDto findById(Long id) {
        if (store.get(id) != null) {
            Post post = store.get(id);
            PostResponseDto postResponseDto = new PostResponseDto(post);
            return postResponseDto;
        } else {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
    }

    public Long delete(Long id, String password) {
        Post deletePost = store.get(id);

        if (deletePost != null) {
            if (deletePost.getPassword().equals(password)) {
                store.remove(id);
                return id;
            } else {
                throw new InputMismatchException("비밀번호가 틀렸습니다.");
            }
        } else {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
    }

    public Long update(Long id, Post post) {
        Post updatePost = store.get(id);

        if (updatePost != null) {
            store.put(id, post);
            return id;
        } else {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
    }
}
