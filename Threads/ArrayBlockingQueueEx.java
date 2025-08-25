import java.util.concurrent.*;

public class ArrayBlockingQueueEx { // cant add null
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2); // capacity = 2 (fixed size)

        Thread producer = new Thread(() -> {
            try {
                queue.put("One");
                System.out.println("Produced: One");
                queue.put("Two");
                System.out.println("Produced: Two");
                queue.put("Three"); // blocks if queue is full
                System.out.println("Produced: Three");
                queue.put("Four"); // blocks if queue is full
                System.out.println("Produced: Four");
                queue.put("Five"); // blocks if queue is full
                System.out.println("Produced: Five");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(500); // wait a bit before consuming
                System.out.println("Consumed: " + queue.take()); // blocks if queue is empty
                System.out.println("Consumed: " + queue.take()); 
                System.out.println("Consumed: " + queue.take());
                System.out.println("Consumed: " + queue.take());
                System.out.println("Consumed: " + queue.take());


            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        // Wait for both threads to complete
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=== Using other methods ===");
        BlockingQueue<String> smallQueue = new ArrayBlockingQueue<>(2);

        System.out.println("Offering A: " + smallQueue.offer("A")); // returns true if added, false if full
        System.out.println("Offering B: " + smallQueue.offer("B")); 
        System.out.println("Offering C: " + smallQueue.offer("C")); 

        System.out.println("Queue Size: " + smallQueue.size());     
        System.out.println("Peek: " + smallQueue.peek());  // returns null if empty        
        System.out.println("Poll: " + smallQueue.poll());  // returns null if empty       
        System.out.println("Poll: " + smallQueue.poll());  
        System.out.println("Poll: " + smallQueue.poll());  
        smallQueue.put("G");
        smallQueue.clear();


    }
}
