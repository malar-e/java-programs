import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;


// won't allow null values
public class PriorityBlockingQueueEx { // thread safe - a piece of code or data structure can be safely accessed or modified by multiple threads at the same time
    public static void main (String[] args) {
        Queue<Integer> queue = new PriorityBlockingQueue<>(); // this won't maintain order like linked list queue
        Queue<Integer> queueCopy = queue; // Any changes made to one queue will also affect the other
        queue.add(11);
        queue.add(12);
        for (int i=0;i<=10; i++ ) {
            queue.add(i);
        }

        Queue<Integer> queue1 = new PriorityBlockingQueue<>();
        queue1.addAll(queue);

        System.out.println("Queue: " + queue);
        System.out.println("Queue Copy: " + queueCopy);
        System.out.println("Queue 1: " + queue1);
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Removed element 5? " + queue.remove(5));
        System.out.println("Queue after remove(): " + queue);
        System.out.println("Queue peek(): " + queue.peek());
        System.out.println("Queue poll(): " + queue.poll());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Queue contains 5? " + queue.contains(5));
        System.out.println("equals(): " + queue.equals(queueCopy));

        System.out.print("Looping through queue:");
        queue.forEach(n -> System.out.print(n + " "));

        // We can't use Collections methods and sort() on queue.
        // However, we can convert it to a list, sort it, and then convert it back to a queue.
        List<Integer> tempList = new ArrayList<>(queue);
        Collections.sort(tempList, Collections.reverseOrder());
        queue = new LinkedList<>(tempList);
        System.out.println("\nDescending Sorted queue: " + queue);

        System.out.print("Looping through queue:");
        for (int value : queue) {
            System.out.print(value + " ");
        }

        System.out.println("\nequals(): " + queue.equals(queueCopy)); // Both should be from same interface like Queue<> else return false - order and internal heap structure matters

        System.out.println("queue: " + queue);
        System.out.println("queue Copy: " + queueCopy);
        queueCopy.add(11);
        System.out.println("queue after modifying copy: " + queue);
        System.out.println("queue Copy after modification: " + queueCopy);

        String str = queueCopy.toString();
        System.out.println("Queue Copy as String: " + str);
        System.out.println("Hashcode of Queue Copy: " + queueCopy.hashCode());

        queue.clear();
    }
}