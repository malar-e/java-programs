
public class ProducerConsumerEx {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            try {
                String[] items = {"One", "Two", "Three"};
                for (String item : items) {
                    buffer.produce(item);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    buffer.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}


class SharedBuffer  {
    private String item;
    private boolean available = false; // whether buffer has item

    public synchronized void produce(String value) throws InterruptedException {
        while (available) {
            wait(); // wait if item already exists
        }
        item = value;
        available = true;
        System.out.println("Produced: " + value);
        notify(); // notify consumer
    }

    public synchronized String consume() throws InterruptedException {
        while (!available) {
            wait(); // wait if no item to consume
        }
        available = false;
        System.out.println("Consumed: " + item);
        notify(); // notify producer
        return item;
    }
}
