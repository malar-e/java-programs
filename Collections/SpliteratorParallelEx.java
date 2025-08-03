import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;

public class SpliteratorParallelEx {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        Spliterator<Integer> spliterator1 = numbers.spliterator();
        Spliterator<Integer> spliterator2 = spliterator1.trySplit(); // split into 2 parts

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {
            spliterator1.forEachRemaining(n -> {
                System.out.println("Thread 1: " + n);
            });
        };

        Runnable task2 = () -> {
            if (spliterator2 != null) {
                spliterator2.forEachRemaining(n -> {
                    System.out.println("Thread 2: " + n);
                });
            }
        };

        executor.submit(task1);
        executor.submit(task2);

        executor.shutdown();
    }
}
