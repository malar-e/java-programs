public class ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Life Cycle ===");

        SharedResource resource = new SharedResource();
        Thread waitThread = new Thread(() -> resource.waitingMethod(), "WaitThread");
        Thread notifyThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                resource.notifyMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "NotifyThread");
        Thread timedWaitThread = new Thread(() -> resource.timedWaitingMethod(), "TimedWaitThread");
        Thread blockedThread = new Thread(() -> resource.longRunningMethod(), "BlockedThread");
        Thread holdingLockThread = new Thread(() -> resource.longRunningMethod(), "HoldingLockThread");

        waitThread.start();
        notifyThread.start();

        Thread.sleep(1000);

        timedWaitThread.start();
        Thread.sleep(1000);

        holdingLockThread.start();
        Thread.sleep(1000);

        blockedThread.start();


        waitThread.join();
        notifyThread.join();
        timedWaitThread.join();
        holdingLockThread.join();
        blockedThread.join();

        System.out.println("=== All Threads have finished ===");

    }
 }
 class SharedResource {

    synchronized void waitingMethod() {
        System.out.println(Thread.currentThread().getName() + " is going to WAIT");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is WOKEN up and running again");
    }

    void notifyMethod() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is calling notify()");
            try {
                Thread.sleep(1000);
                notify();
                System.out.println(Thread.currentThread().getName() + " is called notify()");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void timedWaitingMethod() {
        System.out.println(Thread.currentThread().getName() + " is going to TIMED_WAIT");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " done waiting with timeout");
    }

    synchronized void longRunningMethod() {
        System.out.println(Thread.currentThread().getName() + " has the LOCK and is running (will sleep)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " releases the lock");
    }

    

}