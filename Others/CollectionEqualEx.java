import java.util.*;
import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;

public class CollectionEqualEx {
    public static void main(String[] args) {

        // ------- List Example -------
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(1, 2, 3));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<Integer> list4 = new Vector<>(Arrays.asList(3, 2, 1));
        System.out.println("List1 equals List2? " + list1.equals(list2)); // true
        System.out.println("List1 equals List3? " + list1.equals(list3)); // false
        System.out.println("List3 equals List4? " + list3.equals(list4)); // true

        // ------- Set Example -------
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(3, 2, 1));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 2, 3));
        Set<Integer> set4 = new LinkedHashSet<>(Arrays.asList(1, 2, 2, 3));
        System.out.println("Set1 equals Set2? " + set1.equals(set2)); // true
        System.out.println("Set2 equals Set3? " + set2.equals(set3)); // true (duplicates ignored)
        System.out.println("Set2 equals Set4? " + set2.equals(set4)); // true

        // ------- Queue Example (LinkedList as Queue) -------
        Queue<Integer> queue1 = new LinkedList<>(Arrays.asList(10, 20, 30));
        Queue<Integer> queue2 = new LinkedList<>(Arrays.asList(10, 20, 30));
        Queue<Integer> queue3 = new LinkedList<>(Arrays.asList(30, 20, 10));
        System.out.println("Queue1 equals Queue2? " + queue1.equals(queue2)); // true
        System.out.println("Queue1 equals Queue3? " + queue1.equals(queue3)); // false

        // ------- PriorityQueue (order not preserved) -------
        Queue<Integer> pq1 = new PriorityQueue<>(Arrays.asList(5, 10, 15));
        Queue<Integer> pq2 = new PriorityQueue<>(Arrays.asList(5, 15, 10));
        System.out.println("PriorityQueue pq1 equals pq2? " + pq1.equals(pq2)); // true (based on contents)

        Deque<Integer> dq1 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Deque<Integer> dq2 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Deque<Integer> dq3 = new LinkedList<>(Arrays.asList(1, 2, 3));
        Deque<Integer> dq4 = new LinkedList<>(Arrays.asList(1, 2, 3));
        System.out.println("Deque1 equals Deque2? " + dq1.equals(dq2)); // false - checks reference
        System.out.println("Deque3 equals Deque4? " + dq3.equals(dq4)); // true

        // ------- Map Example -------
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(2, "B");
        map2.put(1, "A");

        Map<Integer, String> map3 = new TreeMap<>();
        map3.put(3, "A");
        map3.put(2, "C");
        map3.put(2, "C");

        Map<Integer, String> map4 = new LinkedHashMap<>();
        map4.put(2, "C");
        map4.put(3, "A");
        map4.put(2, "C");

        System.out.println("Map1 equals Map2? " + map1.equals(map2)); // true
        System.out.println("Map3 equals Map4? " + map3.equals(map4)); // true
        System.out.println("Map1 equals Map4? " + map1.equals(map4)); // false

        // ------- Cross-Type Comparison -------
        System.out.println("List1 equals Set1? " + list1.equals(set1)); // false
        System.out.println("Set1 equals Queue1? " + set1.equals(queue1)); // false

        // -------- same interface but different classes ----------
        System.out.println("Queue1 equals pq1? " + queue1.equals(pq1)); // false - both has two different implementations of equals()
        System.out.println("dq1 equals dq3? " + dq1.equals(dq3));
    }
}
