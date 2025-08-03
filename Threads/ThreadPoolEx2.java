import java.util.*;
import java.time.*;
import java.util.concurrent.*;

public class ThreadPoolEx2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable r1 = new MyTask("task 1");
        Runnable r2 = new MyTask("task 2");
        Runnable r3 = new MyTask("task 3");
        Runnable r4 = new MyTask("task 4");
        Runnable r5 = new MyTask("task 5"); 

        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);
        executorService.submit(r4);
        executorService.submit(r5);

        executorService.shutdown();
    }
}

class MyTask implements Runnable {
    String name;

    MyTask (String name) {
        this.name = name;
    }

    public void run() {
        try {
            for (int i=0;i<5;i++) {
                if(i==0) {
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println("Task " + name + " started at: " + now);

                }
                else {
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println("Task " + name + " Running at: " + now);

                }
                Thread.sleep(1000);
            }
        }
        catch (Exception e){
            System.out.println("Exception in task " + name + ": " + e.getMessage());
        } finally {
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Task " + name + " finished at: " + now);
        }
    }


}