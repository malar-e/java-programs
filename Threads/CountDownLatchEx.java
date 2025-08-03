import java.util.concurrent.*;

public class CountDownLatchEx {
    public static void main(String[] args) {
        System.out.println("=== Application Example ===");
        CountDownLatch latch = new CountDownLatch(3);

        App appThread = new App(latch);
        Database dbThread = new Database(latch);
        CacheSys cacheThread = new CacheSys(latch);
        Server serverThread = new Server(latch);

        appThread.start();
        dbThread.start();
        cacheThread.start();
        serverThread.start();
        try {
            appThread.join();
            dbThread.join();
            cacheThread.join();
            serverThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("All threads have finished execution.");

        System.out.println("\n=== Game Example ===");
        CountDownLatch gameLatch = new CountDownLatch(3);
        Coach coachThread = new Coach(gameLatch);
        Player1 player1Thread = new Player1(gameLatch);
        Player2 player2Thread = new Player2(gameLatch);
        Player3 player3Thread = new Player3(gameLatch);

        player1Thread.start();
        player2Thread.start();
        player3Thread.start();
        coachThread.start();

        try {
            coachThread.join();
            player1Thread.join();
            player2Thread.join();
            player3Thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("All game threads have finished execution.");
    }
}

class Database extends Thread {

    CountDownLatch latch;
    public Database(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Database thread started");
        try {
            Thread.sleep(2000);
            latch.countDown();
        } catch (InterruptedException e) {
            System.out.println("Database thread interrupted");
        } 
        System.out.println("Database thread finished");
    }

}

class CacheSys extends Thread {

    CountDownLatch latch;
    public CacheSys(CountDownLatch latch) {
        this.latch = latch;
    }
    

    public void run() {
        System.out.println("CacheSys thread started");
        try {
            Thread.sleep(2000);
            latch.countDown();
        } catch (InterruptedException e) {
            System.out.println("CacheSys thread interrupted");
        } 
        System.out.println("CacheSys thread finished");
    }

}

class Server extends Thread {

    CountDownLatch latch;
    public Server(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Server thread started");
        try {
            Thread.sleep(2000);
            latch.countDown();
        } catch (InterruptedException e) {
            System.out.println("Server thread interrupted");
        } 
        System.out.println("Server thread finished");

}

}

class App extends Thread {
    CountDownLatch latch;
    public App(CountDownLatch latch) {
        this.latch = latch;
    }
    
    public void run() {
        System.out.println("App thread started, waiting for other threads to finish");
        try {
            latch.await();
            System.out.println("All threads have finished, App is running now");
        } catch (InterruptedException e) {
            System.out.println("App thread interrupted");
        }
    }
}

class Player1 extends Thread {
    CountDownLatch latch;

    public Player1(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Player 1 is waiting for the game to start");
        try {
            latch.await();
            System.out.println("Player 1 is now playing the game");
        } catch (InterruptedException e) {
            System.out.println("Player 1 interrupted");
        } 
    }
}

class Player2 extends Thread {
    CountDownLatch latch;

    public Player2(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Player 2 is waiting for the game to start");
        try {
            latch.await();
            System.out.println("Player 2 is now playing the game");
        } catch (InterruptedException e) {
            System.out.println("Player 2 interrupted");
        } 
    }
}

class Player3 extends Thread {
    CountDownLatch latch;

    public Player3(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Player 3 is waiting for the game to start");
        try {
            latch.await();
            System.out.println("Player 3 is now playing the game");
        } catch (InterruptedException e) {
            System.out.println("Player 3 interrupted");
        } 
    }
}

class Coach extends Thread {
    CountDownLatch latch;

    public Coach(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Coach is going to start the game");
        try {
            Thread.sleep(500); 
            latch.countDown();
            System.out.println("Ready");
            Thread.sleep(500);
            latch.countDown();
            System.out.println("Set");
            Thread.sleep(500);
            latch.countDown();
            System.out.println("Go!");
        } catch (InterruptedException e) {
            System.out.println("Coach interrupted");
        } 
    }
}