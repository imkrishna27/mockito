package mockito.examples.controller;

import mockito.examples.client.FeignUtil;
import mockito.examples.entity.PostEntity;
import mockito.examples.model.Post;
import mockito.examples.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dummy-json")
public class SaveDummyJsonController {

    private final FeignUtil feignUtil;

    private final PostService postService;

    @Autowired
    public SaveDummyJsonController(FeignUtil feignUtil, PostService postService) {
        this.feignUtil = feignUtil;
        this.postService = postService;
    }

    @GetMapping(produces = {"text/plain", "application/*"}, value = "/posts")
    public ResponseEntity saveData() {
        //get data from external api
        List<Post> posts = this.feignUtil.getPosts();
        int size = this.postService.savePosts(posts);
        return ResponseEntity.status(200).body("All" + " "+ size + " posts saved");
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post getPostById(@PathVariable("id") int id) {
        return postService.getPostById(id);
    }
}
