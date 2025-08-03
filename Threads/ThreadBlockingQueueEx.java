import java.util.concurrent.*;
import java.util.*;

public class ThreadBlockingQueueEx {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        queue.put(new Task(5, "Low priority task"));
        queue.put(new Task(1, "High priority task"));
        queue.put(new Task(3, "Medium priority task"));

        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.take());
        }
    }
}

class Task implements Comparable<Task>{
    int priority;
    String name;

    public Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    public String toString() {
        return name + " (priority=" + priority + ")";
    }
}
