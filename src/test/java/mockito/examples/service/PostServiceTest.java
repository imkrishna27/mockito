package mockito.examples.service;

import mockito.examples.entity.PostEntity;
import mockito.examples.model.Post;
import mockito.examples.repository.PostRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@DataJpaTest
public class PostServiceTest {
    @Autowired
    PostRepository postRepository;

    @Test
    public void savePosts() {
        PostService postService = spy(new PostService(postRepository));
        // saving to db so that we can fetch it later
        int size = postService.savePosts(
                Arrays.asList(
                        new Post(12, 12, "title12", "body12"),
                        new Post(13, 13, "title13", "body13")));

        Assertions.assertEquals(2,size);
    }

    @Test
    public void getPostById() {
        PostService postService = spy(new PostService(postRepository));
        // saving to db so that we can fetch it later
        postService.savePosts(Arrays.asList(new Post(1,1,"title","body")));
        // getting saved instance
        Post postById = postService.getPostById(1);
        verify(postService).getPostById(1);
        Assertions.assertEquals(1,postById.getId());
        Assertions.assertEquals("title",postById.getTitle());
    }
}