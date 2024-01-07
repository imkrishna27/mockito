package mockito.examples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    @Autowired PostService postService;
    public void asyncMethod() throws InterruptedException {
        Thread.sleep(1000);
    }
}
