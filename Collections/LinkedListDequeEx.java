import java.util.*;

// won't allow null values
public class LinkedListDequeEx {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> dequeCopy = deque; // Any changes made to one deque will also affect the other

        for (int i = 0; i <= 10; i++) {
            deque.add(i);
        }
        deque.addFirst(-1); // Adding element at the front
        deque.addLast(11); // Adding element at the back

        Deque<Integer> deque1 = new LinkedList<>();
        deque1.addAll(deque);

        System.out.println("Deque: " + deque);
        System.out.println("Deque Copy: " + dequeCopy);
        System.out.println("Deque 1: " + deque1);

        System.out.println("Removed element from front: " + deque.removeFirst());
        System.out.println("Removed element from back: " + deque.removeLast());
        System.out.println("Deque after remove(): " + deque);

        System.out.println("Peek first element: " + deque.peekFirst());
        System.out.println("Peek last element: " + deque.peekLast());

        System.out.println("Poll first element: " + deque.pollFirst());
        System.out.println("Poll last element: " + deque.pollLast());

        System.out.println("Deque size: " + deque.size());
        System.out.println("Is deque empty? " + deque.isEmpty());
        System.out.println("Deque contains 5? " + deque.contains(5));
        System.out.println("equals(): " + deque.equals(dequeCopy));

        System.out.print("Looping through deque:");
        deque.forEach(n -> System.out.print(n + " "));

        // We can't use Collections methods and sort() on deque.
        // However, we can convert it to a list, sort it, and then convert it back to a deque.
        List<Integer> tempList = new ArrayList<>(deque);
        Collections.sort(tempList, Collections.reverseOrder());
        deque = new LinkedList<>(tempList);
        System.out.println("\nDescending Sorted deque: " + deque);

        System.out.print("Looping through deque:");
        for (int value : deque) {
            System.out.print(value + " ");
        }

        System.out.println("\nequals(): " + deque.equals(dequeCopy)); // Both should be from same interface like deque<> else return false - order and duplicates matters

        System.out.println("deque: " + deque);
        System.out.println("deque Copy: " + dequeCopy);
        dequeCopy.addLast(11);
        System.out.println("deque after modifying copy: " + deque);
        System.out.println("deque Copy after modification: " + dequeCopy);

        String str = dequeCopy.toString();
        System.out.println("Deque Copy as String: " + str);
        System.out.println("Hashcode of Deque Copy: " + dequeCopy.hashCode());

        deque.clear();
        
    }
}