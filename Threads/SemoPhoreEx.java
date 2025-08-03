import java.util.concurrent.*;
import java.util.*;

public class SemoPhoreEx {
    public static void main(String[] args) throws Exception{

         System.out.println("=== Starting photo uploading simulation ===");

        Semaphore photo = new Semaphore(0);

        Runnable processing = () -> {

            photo.acquireUninterruptibly(); // ignores InterruptedException while waits
            System.out.println("Processing photo...");
            System.out.println("Photo processed");

        };

        Runnable uploading = () -> {
            try {
                System.out.println("Uploading photo...");
                Thread.sleep(3000);
                System.out.println("Photo uploaded");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                photo.release();
            }
        };

        Thread processingThread = new Thread(processing);
        Thread uploadingThread = new Thread(uploading);

        processingThread.start();
        processingThread.interrupt();
        uploadingThread.start();

        try {
            processingThread.join();
            uploadingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Starting ice cream simulation ===");

        Semaphore iceCream = new Semaphore(3);

        for (int i=0; i<5; i++) {
            new IceCream(iceCream).start();
        }

        Thread.sleep(5000);

        System.out.println("\nPermits Left: " + iceCream.availablePermits());
        int drained = iceCream.drainPermits();
        System.out.println("Drained Permits: " + drained);
        System.out.println("Permits Left after drain: " + iceCream.availablePermits());
        if(iceCream.tryAcquire()) {
            System.out.println("Acquired a permit after draining");
        } else {
            System.out.println("No permits available after draining");
        }
        iceCream.release(2);
        System.out.println("Released 2 permits");
        System.out.println("Permits Left after release: " + iceCream.availablePermits());
        if(iceCream.tryAcquire(1, TimeUnit.SECONDS)) {
            System.out.println("Acquired a permit after releasing");
        } else {
            System.out.println("No permits available after releasing");
        }

        System.out.println("Number of waiting threads: " + iceCream.getQueueLength());
        if(iceCream.hasQueuedThreads()) {
            System.out.println("There are threads waiting for permits");
        } else {
            System.out.println("No threads are waiting for permits");
        }

        System.out.println("\nMySemaphore with fairness:");

        MySemaphore msp = new MySemaphore(3, true);

        for (int i=0; i<5; i++) {
            new IceCream(msp).start();
        }

        Thread.sleep(1000);

        System.out.println("Queued Threads: " + msp.getWaitingThreads());

        System.out.println("\nMySemaphore without fairness:");
        MySemaphore msp1 = new MySemaphore(3);

        for (int i=0; i<5; i++) {
            new IceCream(msp1).start();
        }

        Thread.sleep(1000);

        System.out.println("Queued Threads: " + msp1.getWaitingThreads());


    }
}

class IceCream extends Thread {
    Semaphore iceCream;
    public IceCream(Semaphore iceCream) {
        this.iceCream = iceCream;
    }
    public void run() {
        try {
            iceCream.acquire();
            System.out.println(Thread.currentThread().getName() + " is enjoying ice cream");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        } finally {
            iceCream.release();
            System.out.println(Thread.currentThread().getName() + " has finished ice cream");
        }
    }
}

class MySemaphore extends Semaphore {
    public MySemaphore(int permits) {
        super(permits);
    }

    public MySemaphore(int permits, boolean fair) {
        super(permits, fair);
    }

    public Collection<Thread> getWaitingThreads() {
        return getQueuedThreads();
    }

}
