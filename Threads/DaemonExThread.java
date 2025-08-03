public class DaemonExThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        System.out.println("Thread state: " + thread.getState());

        thread.start();
        System.out.println("Thread state after start: " + thread.getState());

        Thread.sleep(1000);
        System.out.println("Thread state after sleep: " + thread.getState());

        thread.join();
        System.out.println("Thread terminated: " + thread.getState());

        Thread thread1 = new Thread(() -> {
            MyClass.myStaticSynchronizedMethod();
        }, "MyThread1");

        Thread thread2 = new Thread(() -> {
            MyClass.myStaticSynchronizedMethod();
        }, "MyThread2");
        
        thread1.start();
        thread2.start();

        Thread autoSaveThread = new Thread(new AutoSave());
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        System.out.println("Main thread is finished");
    }
}
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
        try {
            Thread.sleep(2000);
            synchronized(this) {
                System.out.println("Thread is in synchronized block");
                wait(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished execution");
    }
}

class MyClass {
    static synchronized void myStaticSynchronizedMethod() {
       System.out.println(Thread.currentThread().getName() + " is executing myStaticSynchronizedMethod");
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println(Thread.currentThread().getName() + " has finished executing myStaticSynchronizedMethod");
    }
}

class AutoSave implements Runnable {
    public void run() {
        while (true) {
            System.out.println("Auto-saving...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
