package mockito.examples.client;

import mockito.examples.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "json-placeholder", url = "https://jsonplaceholder.typicode.com")
public interface FeignUtil {
    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<Post> getPosts();
}
