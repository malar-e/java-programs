public class ThreadSync {
    public static void main (String[] args) throws InterruptedException {

        Sender send1 = new Sender();
        Sender send2 = new Sender();
        Sender send3 = new Sender();

        MyThread thread1 = new MyThread("Hello from Thread 1", send1);
        MyThread thread2 = new MyThread("Hello from Thread 2", send1);
        MyThread thread3 = new MyThread("Hello from Thread 3", send2);
        MyThread thread4 = new MyThread("Hello from Thread 4", send2);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        send3.send("Hello from send 3 obj");

    
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        

        System.out.println("All threads have finished execution.");
        System.out.println("\n=== Bank class ===");

        Thread thread5 = new Thread(() -> {
            for (int i=0;i<4; i++) {
                Bank.deposit(100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }
            }
        });

        Thread thread6 = new Thread(() -> {
            for (int i=0;i<4; i++) {
                Bank.withdraw(100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }
            }
        });
        thread5.start();
        thread6.start();

        
        thread5.join();
        thread6.join();
       
        System.out.println("Final Balance: " + Bank.getBalance());





    }
}

class Sender {
    public void send(String msg) {
        System.out.println("Sending " + msg);
        try {
            Thread.sleep(100);
        }
        catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
        System.out.println(msg + " Sent");

    }
}

class MyThread extends Thread {
    private String msg;
    Sender obj;

    MyThread(String msg, Sender obj) {
        this.msg = msg;
        this.obj = obj;
    }

    public void run() {
        System.out.println("Thread started: " + msg);
        synchronized(obj) {
            obj.send(msg);
        }

    }
}

class Bank {
    private static int balance = 0;
    
    static synchronized void deposit (int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    static void withdraw (int amount) {
        synchronized(Bank.class) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            }
            else {
                System.out.println("Insufficient balance"); 
            }
        }
    }

    static synchronized int getBalance() {
        return balance;
    }


}