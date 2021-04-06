package atlanssian.ratelimiter;

import java.util.concurrent.Callable;

public class ApiRequest implements Callable {
    private RateLimiter rateLimiter;

    public ApiRequest(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Override
    public Object call() throws Exception {
        if (rateLimiter.consumeToken()) {
            return true;
        }
        return false;
    }
}
