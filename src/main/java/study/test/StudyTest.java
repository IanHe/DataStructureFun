package study.test;

import java.util.concurrent.TimeUnit;

public class StudyTest {
    private static boolean stopRequested;

//    private static synchronized void requestStop() {
//        stopRequested = true;
//    }
//
//    private static synchronized boolean stopRequested() {
//        return stopRequested;
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread bgThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                System.out.println(i);
                i++;
            }
        });
        bgThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
