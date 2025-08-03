import java.util.*;
import java.util.Arrays;

// Can't convert any of these Collections to Map.

public class CollectionConversionExample {
    public static void main(String[] args) {

        // 1. Immutable List using List.of
        List<String> immutableList = List.of("Apple", "Banana", "Cherry");
        System.out.println("Immutable List: " + immutableList);

        // 2. Immutable Set using Set.of
        Set<String> set = Set.of("a", "b", "c");

        // 3. Immutable Map using Map.of
        Map<String, Integer> map = Map.of("a", 1, "b", 2);

        // For more than 10 entries, use: Immutable
        Map<String, Integer> map2 = Map.ofEntries(
            Map.entry("x", 10),
            Map.entry("y", 20)
        );

        // 2. Convert List to Set (removes duplicates)
        Set<String> setFromList = new HashSet<>(immutableList);
        System.out.println("Set from List: " + setFromList);

        // 3. Convert Set to List
        List<String> listFromSet = new ArrayList<>(setFromList);
        System.out.println("List from Set: " + listFromSet);

        // 4. Convert List to LinkedList
        LinkedList<String> linkedListFromList = new LinkedList<>(listFromSet);
        System.out.println("LinkedList from List: " + linkedListFromList);

        // 5. Convert LinkedList to Queue
        Queue<String> queueFromLinkedList = new LinkedList<>(linkedListFromList);
        System.out.println("Queue from LinkedList: " + queueFromLinkedList);

        // 6. Convert List to Array
        String[] arrayFromList = listFromSet.toArray(new String[0]);
        System.out.println("Array from List: " + Arrays.toString(arrayFromList));

        // 7. Convert Array to List (modifiable)
        String[] animals = {"Dog", "Cat", "Elephant"};
        List<String> listFromArray = new ArrayList<>(Arrays.asList(animals));
        listFromArray.add("Lion");
        System.out.println("List from Array: " + listFromArray);

        // 8. Convert List to TreeSet (sorted and unique)
        TreeSet<String> treeSetFromList = new TreeSet<>(listFromArray);
        System.out.println("TreeSet from List: " + treeSetFromList);

        // 9. Convert TreeSet to LinkedList
        LinkedList<String> linkedListFromSet = new LinkedList<>(treeSetFromList);
        System.out.println("LinkedList from TreeSet: " + linkedListFromSet);

        // 10. Convert List to Stack
        Stack<String> stackFromList = new Stack<>();
        stackFromList.addAll(listFromArray);
        System.out.println("Stack from List: " + stackFromList);
    }
}
