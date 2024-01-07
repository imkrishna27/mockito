package mockito.examples.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AsyncServiceTest {
    @Mock
    private AsyncService asyncService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void asyncMethod() throws InterruptedException {
        asyncService.asyncMethod();
        verify(asyncService,after(10)).asyncMethod();
    }
}