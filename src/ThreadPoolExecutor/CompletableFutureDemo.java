package ThreadPoolExecutor;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            return "Result";
        }).thenAccept(result -> {
            System.out.println("Task result: " + result);
        });
    }
}
