public class VolatileEx {
    public static void main (String[] args) throws Exception {

        Worker worker = new Worker();
        worker.start();

        Thread.sleep(1000);

        worker.interruptWorker();

        worker.join();

        Worker1 worker1 = new Worker1();
        worker1.start();

        Thread.sleep(1000);

        System.out.println("Worker1 is interrupted: " + Worker1.getIsInterrupted());

        worker1.join();

    }
}

class Worker extends Thread {
    private volatile boolean isInterrupted = false;

    public void run() {
        while (!isInterrupted) {
            System.out.println("Worker is working...");
        }
    }

    public void interruptWorker() {
        isInterrupted = true;
    }
}

class Worker1 extends Thread {
    private static volatile boolean isInterrupted = false;

    public void run() {
        isInterrupted = true;
    }

    public static boolean getIsInterrupted() {
        return isInterrupted;
    }
}

