import java.util.concurrent.*;
import java.util.*;
import java.util.Arrays;

public class ThreadPoolExecutorEx {
    public static void main(String[] args) throws Exception {

        System.out.println("=== Custom Executor ===");
        MyExecutor executor = new MyExecutor();
        executor.execute(() -> System.out.println("MyExecutor is executing a task"));
        executor.execute(new MyTask("Task 1"));

        System.out.println("=== Executor Interface ===");
        Executor executorInterface = Executors.newSingleThreadExecutor();
        executorInterface.execute(() -> {
            System.out.println("Executor interface is executing a task");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
            }
        });
        executorInterface.execute(() -> {
            System.out.println("Executor interface is executing another task");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
            }
        });

        System.out.println("=== ExecutorService (Fixed) ===");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> System.out.println("ExecutorService is executing a task"));

        MyTask task2 = new MyTask("Task 2");
        executorService.submit((Runnable) task2); // disambiguate

        Future<String> future = executorService.submit((Callable<String>) new MyTask("Task 3"));
        System.out.println("Result from Task 3: " + future.get());

        System.out.println("=== ExecutorService (Cached) ===");
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(() -> System.out.println("ExecutorService 2 is executing a task"));
        executorService2.submit((Runnable) new MyTask("Task 4"));

        System.out.println("=== invokeAll ===");
        List<Callable<String>> tasks = Arrays.asList(
            new MyTask("invokeAll-1"),
            new MyTask("invokeAll-2"),
            new MyTask("invokeAll-3")
        );
        List<Future<String>> allResults = executorService.invokeAll(tasks);
        for (Future<String> result : allResults) {
            System.out.println("invokeAll result: " + result.get());
        }

        System.out.println("=== invokeAny ===");
        List<Callable<String>> tasks2 = Arrays.asList(
            () -> {
                Thread.sleep(1000);
                return "Fastest task";
            },
            () -> {
                Thread.sleep(2000);
                return "Slower task";
            }
        );
        try {
            String anyResult = executorService.invokeAny(tasks2);
            System.out.println("Result from invokeAny: " + anyResult);
        } catch (Exception e) {
            System.out.println("Exception in invokeAny: " + e.getMessage());
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("=== ThreadPoolExecutor ===");
        ExecutorService executorService3 = new ThreadPoolExecutor(
            2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>()
        );

        Future<String> future3 = executorService3.submit(() -> {
            Thread.sleep(6000);
            return "Long task finished";
        });

        future3.cancel(true);
        System.out.println("Was future3 cancelled? " + future3.isCancelled());
        System.out.println("Was future3 done? " + future3.isDone());


        executorService3.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("ExecutorService3 task executed");
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
            }
        });

        executorService3.shutdown();
        try {
            if (!executorService3.awaitTermination(2, TimeUnit.SECONDS)) {
                executorService3.shutdownNow();
                System.out.println("ExecutorService3 was shut down");
            } else {
                System.out.println("ExecutorService3 completed all tasks");
            }
        } catch (InterruptedException e) {
            executorService3.shutdownNow();
            System.out.println("ExecutorService3 was interrupted");
        }

        if (executorService3.isShutdown()) {
            System.out.println("ExecutorService3 is shut down");
        }

        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3); // it can run all other methods like a regular executor
        scheduledExecutor.schedule(() -> { // can call runnable, callable
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Scheduled task executed immediately after 10 seconds");
        }, 10, TimeUnit.SECONDS);

        ScheduledFuture<String> future1 = scheduledExecutor.schedule(() -> { // ScheduledFuture has all methods like Future with getDelay()
            return "Scheduled task executed after 10 seconds";
        }, 10, TimeUnit.SECONDS);

        for (int i = 0; i < 5; i++) {
            long delay = future1.getDelay(TimeUnit.SECONDS);
            System.out.println("Time left before task runs: " + delay + " seconds");
            Thread.sleep(1000);
        }
        
        System.out.println("Result from future1: " + future1.get());

        scheduledExecutor.scheduleAtFixedRate(() -> { // only can call runnable, stops when call shutdown
            System.out.println("Scheduled task executed at fixed rate every 3 seconds");
        }, 0, 3, TimeUnit.SECONDS);

        scheduledExecutor.scheduleWithFixedDelay(() -> { // only can call runnable, stops when call shutdown
            System.out.println("Scheduled task executed with fixed delay every 4 seconds");
        }, 0, 4, TimeUnit.SECONDS);

        scheduledExecutor.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Submitted task executed immediately");
        });

        Thread.sleep(2000);

        scheduledExecutor.shutdown(); // after calling shutdown the scheduled tasks get terminated

        Future<String> future2 = executorService2.submit((Callable<String>) new MyTask("Task 5"));
        System.out.println("Result from Task 5: " + future2.get(300, TimeUnit.MILLISECONDS)); // Give you timeout exception if the result is not coming within 3 ms.
        System.out.println("Was future2 cancelled? " + future2.isCancelled());
        System.out.println("Was future2 done? " + future2.isDone());

        executorService2.shutdown();
        executorService2.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("=== All Done ===");
    }
}

// Custom Executor
class MyExecutor implements Executor {
    public void execute(Runnable command) {
        Thread t = new Thread(command);
        t.setDaemon(true);
        t.start();

    }
}

// Task that can be both Runnable and Callable
class MyTask implements Runnable, Callable<String> {
    private String name;

    MyTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " is running (Runnable)");
    }

    public String call() throws Exception {
        Thread.sleep(500);
        return name + " (Callable result)";
    }
}
