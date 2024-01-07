package mockito.examples.service;

import mockito.examples.entity.PostEntity;
import mockito.examples.model.Post;
import mockito.examples.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public int savePosts(List<Post> posts) {
        List<PostEntity> postEntities = posts.stream().map(post -> {
            return new PostEntity(post.getUsedId(), post.getId(), post.getTitle(), post.getBody());
        }).toList();
        List<PostEntity> savedEntities = postRepository.saveAll(postEntities);
        return savedEntities.size();
    }

    public Post getPostById(int id) {
        PostEntity postEntity = this.postRepository.findFirstByUsedId(id);
        return new Post(postEntity.getUsedId(),postEntity.getId(),postEntity.getTitle(),postEntity.getBody());
    }
}
