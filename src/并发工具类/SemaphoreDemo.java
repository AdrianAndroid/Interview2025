package 并发工具类;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 初始化 Semaphore，许可证数量为 2
        Semaphore semaphore = new Semaphore(2);

        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 尝试获取许可证");
                    semaphore.acquire(); // 获取许可证
                    System.out.println(Thread.currentThread().getName() + " 获取到许可证，开始执行任务");
                    Thread.sleep(1000); // 模拟任务执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " 释放许可证");
                    semaphore.release(); // 释放许可证
                }
            });
        }

        executor.shutdown(); // 关闭线程池
    }
}