package 并发工具类;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 初始化 CyclicBarrier，屏障数为 3，所有线程到达屏障后会执行一个 Runnable
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("所有线程已到达屏障，继续执行");
        });

        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " 开始执行任务");
                try {
                    Thread.sleep(1000); // 模拟任务执行时间
                    System.out.println(Thread.currentThread().getName() + " 到达屏障，等待其他线程");
                    barrier.await(); // 等待其他线程到达屏障
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 继续执行后续任务");
            });
        }

        executor.shutdown(); // 关闭线程池
    }
}
