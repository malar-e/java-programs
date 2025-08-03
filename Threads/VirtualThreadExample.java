import java.util.concurrent.*;

public class VirtualThreadExample {

    public static void main(String[] args) throws Exception {
        // Virtual Thread using Thread.ofVirtual().start()
        Thread vt1 = Thread.ofVirtual().start(() -> {
            System.out.println("Hello from a virtual thread!");
        });
        vt1.join();

        // Virtual Thread using Thread.ofVirtual().unstarted()
        Thread vt2 = Thread.ofVirtual().unstarted(() -> {
            System.out.println("Hello from another virtual thread!");
        });
        vt2.start();
        vt2.join();

        // Virtual Thread using Thread.startVirtualThread()
        Thread vt3 = Thread.startVirtualThread(() -> {
            System.out.println("Hello from a virtual thread!");
        });
        vt3.join();

        Thread vt4 = Thread.startVirtualThread(() -> {
            System.out.println("Hello from another virtual thread!");
        });
        vt4.join();

        // Using Callable with FutureTask in a virtual thread
        Callable<String> callable = () -> {
            return "Hello from a callable!";
        };

        FutureTask<String> task = new FutureTask<>(callable);
        Thread vt5 = Thread.ofVirtual().start(task);
        String result = task.get();
        System.out.println(result);
        vt5.join();

        FutureTask<String> task1 = new FutureTask<>(callable);
        Thread vt6 = Thread.startVirtualThread(task1);
        String result1 = task1.get();
        System.out.println(result1);
        vt6.join();

        // Using Runnable with FutureTask in a virtual thread
        Runnable runnable = () -> {
            System.out.println("Hello from a runnable!");
        };

        FutureTask<String> task2 = new FutureTask<>(runnable, "Runnable result!");
        Thread vt7 = Thread.startVirtualThread(task2);
        String result2 = task2.get();
        System.out.println(result2);
        vt7.join();

        FutureTask<String> task3 = new FutureTask<>(runnable, "Runnable result!");
        Thread vt8 = Thread.ofVirtual().start(task3);
        String result3 = task3.get();
        System.out.println(result3);
        vt8.join();

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(() -> {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
            }
            System.out.println("Hello from a virtual thread in an executor!");
        });
        Future<String> future = executor.submit(() -> {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
            }
            return "Hello from a callable in an executor!";
        });
        System.out.println(future.get());
        executor.submit(() -> {
            System.out.println("Hello from a virtual thread in an executor!");
        });

    }
}
