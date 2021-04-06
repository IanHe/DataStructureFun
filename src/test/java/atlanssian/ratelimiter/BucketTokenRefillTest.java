package atlanssian.ratelimiter;

import org.testng.annotations.Test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class BucketTokenRefillTest {

    @Test
    public void testRefillBucket_whenBucketIsEmpty_thenFinallyBucketSizeShouldBe20() throws InterruptedException {
        BlockingDeque<BucketToken> bucket = new LinkedBlockingDeque<>(20);
        BucketTokenRefill bucketTokenRefill = new BucketTokenRefill(bucket, 20);
        new Thread(bucketTokenRefill).start();
        Thread.sleep(4000);
        assertEquals(bucket.size(), 20);
        Thread.sleep(2000);
        assertEquals(bucket.size(), 20);
    }

    @Test
    public void testRefillBucket_givenBucketIsFull_whenBucketPollToken_thenFinallyBucketSizeShouldBe20() throws InterruptedException {
        BlockingDeque<BucketToken> bucket = new LinkedBlockingDeque<>(20);
        BucketTokenRefill bucketTokenRefill = new BucketTokenRefill(bucket, 20);
        for (int i = 0; i < 20; i++) {
            bucket.add(new BucketToken());
        }
        new Thread(bucketTokenRefill).start();
        for (int i = 0; i < 10; i++) {
            bucket.poll();
        }
        assertNotEquals(bucket.size(), 20);
        Thread.sleep(4000);
        assertEquals(bucket.size(), 20);
    }
}