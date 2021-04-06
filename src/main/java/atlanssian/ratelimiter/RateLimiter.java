package atlanssian.ratelimiter;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/*
    1. One token bucket just handle 1 type of request
    2. Algorithm: Token bucket
       a. Bucket size: 20
       b. Refill rate: 5 / second
       c. use BlockingQueue to handle concurrency
    3. each request consumes 1 token
       a. if bucket size is empty, drop the request
       b. if bucket size is not empty, process request and take 1 token
 */
public class RateLimiter {
    private static final int BUCKET_SIZE = 20;
    private BlockingDeque<BucketToken> bucket;
    private BucketTokenRefill bucketTokenRefill;

    public RateLimiter() {
        this.bucket = new LinkedBlockingDeque<>(BUCKET_SIZE);
        this.bucketTokenRefill = new BucketTokenRefill(bucket, BUCKET_SIZE);
    }

    public void startRefill() {
        new Thread(this.bucketTokenRefill).start();
    }

    public boolean consumeToken() {
        if (bucket.isEmpty()) {
            return false;
        }
        bucket.poll();
        return true;
    }
}
