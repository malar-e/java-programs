import java.util.*;
import java.util.Arrays;

public class CollectionEx {
    public static void main(String[] args) {

        // ==== 1. List ====
        System.out.println("=== LIST ===");
        Collection<String> listCollection = new ArrayList<>();
        listCollection.add("Apple");
        listCollection.add("Banana");

        System.out.println("Collection (List): " + listCollection);
        listCollection.add("Cherry");
        listCollection.remove("Banana");
        System.out.println("Contains 'Apple'? " + listCollection.contains("Apple"));
        System.out.println("Size: " + listCollection.size());
        listCollection.clear();
        System.out.println("After clear: " + listCollection);

        // Convert back to List and perform operations
        listCollection.addAll(Arrays.asList("Apple", "Banana"));
        List<String> list = new ArrayList<>(listCollection);
        list.add("Mango");
        list.remove("Apple");
        System.out.println("List after operations: " + list);

        System.out.println("------");

        // ==== 2. Set ====
        System.out.println("=== SET ===");
        Collection<String> setCollection = new HashSet<>();
        setCollection.add("Dog");
        setCollection.add("Cat");

        System.out.println("Collection (Set): " + setCollection);
        setCollection.add("Elephant");
        setCollection.remove("Dog");
        System.out.println("Contains 'Cat'? " + setCollection.contains("Cat"));
        System.out.println("Size: " + setCollection.size());
        setCollection.clear();
        System.out.println("After clear: " + setCollection);

        // Convert back to Set
        setCollection.addAll(Arrays.asList("Dog", "Cat"));
        Set<String> set = new HashSet<>(setCollection);
        set.add("Tiger");
        set.remove("Dog");
        System.out.println("Set after operations: " + set);

        System.out.println("------");

        // ==== 3. Queue ====
        System.out.println("=== QUEUE ===");
        Collection<String> queueCollection = new LinkedList<>();
        queueCollection.add("One");
        queueCollection.add("Two");

        System.out.println("Collection (Queue): " + queueCollection);
        queueCollection.add("Three");
        queueCollection.remove("One");
        System.out.println("Contains 'Two'? " + queueCollection.contains("Two"));
        System.out.println("Size: " + queueCollection.size());
        queueCollection.clear();
        System.out.println("After clear: " + queueCollection);

        // Convert back to Queue
        queueCollection.addAll(Arrays.asList("One", "Two"));
        Queue<String> queue = new LinkedList<>(queueCollection);
        queue.add("Four");
        queue.remove("One");
        System.out.println("Queue after operations: " + queue);

        System.out.println("------");

        // ==== 4. Stack ====
        System.out.println("=== STACK ===");
        Collection<String> stackCollection = new Stack<>();
        stackCollection.add("Red");
        stackCollection.add("Blue");

        System.out.println("Collection (Stack): " + stackCollection);
        stackCollection.add("Green");
        stackCollection.remove("Red");
        System.out.println("Contains 'Blue'? " + stackCollection.contains("Blue"));
        System.out.println("Size: " + stackCollection.size());
        stackCollection.clear();
        System.out.println("After clear: " + stackCollection);

        // Convert back to Stack
        stackCollection.addAll(Arrays.asList("Red", "Blue"));
        Stack<String> stack = new Stack<>();
        stack.addAll(stackCollection);
        stack.push("Yellow");
        stack.remove("Red");
        System.out.println("Stack after operations: " + stack);
    }
}
