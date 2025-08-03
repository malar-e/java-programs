import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class LockEx {

    public static void main(String[] args) throws Exception {

        ReentrantLock lock = new ReentrantLock();

        for (int i=0; i<5; i++) {
            new Thread(new ToyRoom(lock), "kid-" + i).start();
        }

        Thread.sleep(1000);
        System.out.println("Is toy room occupied? " + lock.isLocked());
        System.out.println("Is held by current thread? " + lock.isHeldByCurrentThread());
        System.out.println("Number of waiting kids: " + lock.getQueueLength());
        if(lock.tryLock()) {
            System.out.println("Current thread acquired the lock");
        } else {
            System.out.println("Current thread could not acquire the lock");
        }
        System.out.println("Is any kid waiting? " + lock.hasQueuedThreads());
        System.out.println("Is Fair? " + lock.isFair());

        if(lock.tryLock(6, TimeUnit.SECONDS)) {
            System.out.println("Current thread acquired the lock after 6 secs");
        } else {
            System.out.println("Current thread could not acquire the lock");
        }
        System.out.println("Is toy room occupied? " + lock.isLocked());
        lock.unlock();

        ReentrantLock lock1 = new ReentrantLock(true);

        for (int i=5; i<10; i++) {
            new Thread(() -> {
                try{
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + ": Entering toy room");
                    System.out.println(Thread.currentThread().getName() + " held the lock? " + lock1.isHeldByCurrentThread());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                } finally {
                    lock1.unlock();
                }
            }, "kid-" + i).start();
        }

        Thread thread = new Thread(() -> {
                try{
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + ": Entering toy room");
                    System.out.println(Thread.currentThread().getName() + " held the lock? " + lock1.isHeldByCurrentThread());
                    Thread.sleep(1000);
                    lock1.unlock();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                } 
            }, "kid-10");

            Thread thread1 = new Thread(() -> {
                try{
                    lock1.lockInterruptibly();
                    lock1.lock();
                    lock1.lock();
                    System.out.println("HoldCount: " + lock1.getHoldCount());
                    lock1.unlock();
                    lock1.unlock();
                    lock1.unlock();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                } 
            }, "kid-11");

        thread.start();
        thread.interrupt();
        Thread.sleep(1000);
        thread1.start();
        Thread.sleep(2000);
        System.out.println("Kid-11 is queued? " + lock1.hasQueuedThread(thread1));

        System.out.println("Is Fair? " + lock1.isFair());

    }
}

class ToyRoom implements Runnable {
    private ReentrantLock lock;

    public ToyRoom(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": Entering toy room");
            System.out.println(Thread.currentThread().getName() + " held the lock? " + lock.isHeldByCurrentThread());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
        } finally {
            System.out.println(Thread.currentThread().getName() + ": Leaving toy room");
            lock.unlock();
        }
    }
}