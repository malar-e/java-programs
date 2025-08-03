public class InterruptEx {
    public static void main(String[] args) throws InterruptedException {
        // Example 1: Thread sleeping
        Thread sleepingThread = new Thread(() -> {
            try {
                System.out.println("[SleepThread] Going to sleep...");
                Thread.sleep(5000);
                System.out.println("[SleepThread] Woke up normally");
            } catch (InterruptedException e) {
                System.out.println("[SleepThread] Interrupted while sleeping!");
            }
        });

        // Example 2: Thread with loop (manual interrupt check)
        Thread loopingThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("[LoopThread] Working...");
                try {
                    Thread.sleep(1000); // simulate work
                } catch (InterruptedException e) {
                    System.out.println("[LoopThread] Interrupted during sleep!");
                    // Re-set the interrupt flag because sleep clears it
                    System.out.println("Interrupted? " + Thread.interrupted()); // if true, clears the flag
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("[LoopThread] Exiting loop.");
        });

        // Example 3: Thread using Semaphore (acquire)
        java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(0);
        Thread semaphoreThread = new Thread(() -> {
            try {
                System.out.println("[SemaphoreThread] Waiting to acquire...");
                semaphore.acquire(); // interruptible
                System.out.println("[SemaphoreThread] Acquired permit!");
            } catch (InterruptedException e) {
                System.out.println("[SemaphoreThread] Interrupted while waiting on semaphore!");
            }
        });

        sleepingThread.start();
        loopingThread.start();
        semaphoreThread.start();

        // Let threads start their tasks
        Thread.sleep(1000);

        // Interrupt all threads
        sleepingThread.interrupt();
        loopingThread.interrupt();
        semaphoreThread.interrupt();

        // Wait for threads to finish
        sleepingThread.join();
        loopingThread.join();
        semaphoreThread.join();

        System.out.println("Main thread done.");
    }
}
