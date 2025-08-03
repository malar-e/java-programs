import java.util.concurrent.locks.*;

public class ReadWriteLockEx {
    public static void main(String[] args) throws Exception {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        for (int i=0;i<3;i++) {
            new Thread(() -> {
                lock.readLock().lock();
                System.out.println("Reader " + Thread.currentThread().getName() + " is reading...");
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
                lock.readLock().unlock();
                System.out.println("Reader " + Thread.currentThread().getName() + " is done.");
            }).start();
        }

        Thread writer = new Thread(() -> {
            System.out.println("Writer is trying to write...");
            lock.writeLock().lock();  // Will wait until all readers are done
            System.out.println("Writer is writing...");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            lock.writeLock().unlock();
            System.out.println("Writer is done.");
        });

        Thread.sleep(100);  // slight delay to ensure reader1 starts first
        writer.start();

        for (int i=0;i<3;i++) {
            new Thread(() -> {
                lock.readLock().lock();
                System.out.println("Reader " + Thread.currentThread().getName() + " is reading...");
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
                lock.readLock().unlock();
                System.out.println("Reader " + Thread.currentThread().getName() + " is done.");
            }).start();
        }
    }
}

