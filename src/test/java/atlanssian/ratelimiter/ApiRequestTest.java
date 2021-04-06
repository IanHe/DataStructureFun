package atlanssian.ratelimiter;

import org.testng.annotations.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ApiRequestTest {
    @Test
    public void testApiRequest_givenBucketIsNotEmpty_thenApiRequestReturnTrue() throws ExecutionException, InterruptedException {
        RateLimiter rateLimiter = new RateLimiter();
        rateLimiter.startRefill();
        Thread.sleep(1500);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(new ApiRequest(rateLimiter));
        boolean allowed = (Boolean) future.get();
        executor.shutdown();
        assertTrue(allowed);
    }

    @Test
    public void testApiRequest_givenBucketIsEmpty_thenApiRequestReturnFalse() throws ExecutionException, InterruptedException {
        RateLimiter rateLimiter = new RateLimiter();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(new ApiRequest(rateLimiter));
        boolean allowed = (Boolean) future.get();
        executor.shutdown();
        assertFalse(allowed);
    }

    @Test
    public void testApiRequest_givenRateLimiterStarted_whenCallApiEvery1200ms_thenAllApiRequestsShouldBeAllowed() throws ExecutionException, InterruptedException {
        int processors = Runtime.getRuntime().availableProcessors();
        RateLimiter rateLimiter = new RateLimiter();
        ExecutorService executor = Executors.newFixedThreadPool(processors);
        rateLimiter.startRefill();
        AtomicInteger count = new AtomicInteger();
        while(count.getAcquire() < 50) {
            for (int i = 0; i < processors; i++) {
                Future future = executor.submit(new ApiRequest(rateLimiter));
            }
        }
    }
}