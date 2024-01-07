package mockito.examples.controller;

import mockito.examples.client.FeignUtil;
import mockito.examples.model.Post;
import mockito.examples.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class SaveDummyJsonControllerTest {

    @InjectMocks
    private SaveDummyJsonController saveDummyJsonController;

    @Mock
    private FeignUtil feignUtil;

    @Mock PostService postService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testSaveAllPosts() {
        when(postService.savePosts(anyList())).thenReturn(100);
        ResponseEntity responseEntity = this.saveDummyJsonController.saveData();
        assertEquals(200,responseEntity.getStatusCode().value());
        assertEquals("All 100 posts saved",responseEntity.getBody());;
        //verify how many times request was send
        verify(postService,times(1)).savePosts(anyList());
        verify(feignUtil,times(1)).getPosts();

    }
}