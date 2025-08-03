import java.util.concurrent.*;

public class ThreadsEx {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws Exception{

        System.out.println("=== Threads Example ===");
        MyThread thread = new MyThread();
        thread.start();

        MyRunnable runnable = new MyRunnable();
        Thread threadForRunnable = new Thread(runnable); 
        threadForRunnable.start();
        executorService.submit(runnable);

        System.out.println("\n=== Concurrency Problem ===");
        ConcurrencyProblem concurrencyProblem = new ConcurrencyProblem();
        concurrencyProblem.start();
        concurrencyProblem.myMethod();

        System.out.println("\n=== isAlive() ===");
        ConcurrencyProblem concurrencyProblemSolution = new ConcurrencyProblem();
        concurrencyProblemSolution.start();
        while (concurrencyProblemSolution.isAlive()) { // loops again and again until the thread finishes execution.
            System.out.println("Is alive: " + concurrencyProblemSolution.isAlive());
        }
        concurrencyProblemSolution.myMethod();

        System.out.println("\n=== Callable Interface ===");
        try {
            Future<Integer> future = executorService.submit(new MyCallable());
            Integer result = future.get();
            System.out.println("Result from Callable: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown(); // shutdown the executor service
        System.out.println("Executor service is shut down.");

    }
}

//Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

// Runnable Interface
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable is running");
        throw new ArithmeticException("Division by zero");
    }
}

// Callable Interface
class MyCallable implements Callable<Integer> {
    int a = 100;
    int b = 200;
    public Integer call() throws Exception {
        if(a>0 && b>0) {
            return a + b;
        } else {
            throw new Exception("Invalid input");
        }
    }
}

class ConcurrencyProblem extends Thread {
    private int counter = 0;

    public void run() {
        counter++;
    }

    public void myMethod() {
        System.out.println("Counter: " + counter);
        counter++;
        System.out.println("Counter after increment: " + counter);
    }
    
}
