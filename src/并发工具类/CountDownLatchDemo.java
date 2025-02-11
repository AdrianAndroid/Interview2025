package 并发工具类;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 初始化 CountDownLatch，计数器为 3
        CountDownLatch latch = new CountDownLatch(3);

        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " 开始执行任务");
                try {
                    Thread.sleep(1000); // 模拟任务执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 任务执行完成");
                latch.countDown(); // 计数器减 1
            });
        }

        System.out.println("主线程等待所有任务完成...");
        latch.await(); // 主线程等待计数器减到 0
        System.out.println("所有任务已完成，主线程继续执行");

        executor.shutdown(); // 关闭线程池
    }
}