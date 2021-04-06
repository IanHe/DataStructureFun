package atlanssian.ratelimiter;

import java.util.concurrent.BlockingDeque;

public class BucketTokenRefill implements Runnable {
    private final int REFILL_SIZE = 5;
    private final int REFILL_RATE = 1000; // 1000 ms
    private BlockingDeque<BucketToken> bucket;
    private int bucketSize;

    public BucketTokenRefill(BlockingDeque<BucketToken> bucket, int bucketSize) {
        this.bucket = bucket;
        this.bucketSize = bucketSize;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < REFILL_SIZE; i++) {
                if (bucket.size() < this.bucketSize) {
                    this.bucket.add(new BucketToken());
                }
            }
            try {
                Thread.sleep(REFILL_RATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
