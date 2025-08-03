import java.util.*;
import java.util.Arrays;

public class ListCreationExamples {
    public static void main(String[] args) {

        // 1. Immutable list using List.of (Java 9+)
        List<String> list1 = List.of("Apple", "Banana", "Cherry");
        System.out.println("List1 (List.of): " + list1);
        // list1.add("Grapes"); // ❌ Error: UnsupportedOperationException

        // 2. Fixed-size list using Arrays.asList
        List<String> list2 = Arrays.asList("Dog", "Cat", "Horse");
        System.out.println("List2 (Arrays.asList): " + list2);
        list2.set(1, "Rabbit"); // ✅ You can modify existing elements
        System.out.println("List2 after set: " + list2);
        // list2.add("Cow"); // ❌ Error: UnsupportedOperationException

        // 3. Modifiable list using new ArrayList and add()
        List<String> list3 = new ArrayList<>();
        list3.add("Red");
        list3.add("Green");
        list3.add("Blue");
        System.out.println("List3 (ArrayList with add): " + list3);

        // 4. Modifiable list using Collections.addAll()
        List<String> list4 = new ArrayList<>();
        Collections.addAll(list4, "Monday", "Tuesday", "Wednesday");
        System.out.println("List4 (Collections.addAll): " + list4);

        // 5. Modifiable list using new ArrayList<>(List.of(...))
        List<String> list5 = new ArrayList<>(List.of("Circle", "Square", "Triangle"));
        list5.add("Hexagon"); // ✅ You can add/remove elements
        System.out.println("List5 (new ArrayList<>(List.of(...))): " + list5);

        // 6. Using forEach loop to print elements
        System.out.print("\nList5 elements using forEach: ");
        list5.forEach(shape -> System.out.print(shape + " "));

        // 7. Convert list to array
        String[] array = list5.toArray(new String[0]);
        System.out.println("\nList5 as array: " + Arrays.toString(array));

        // 8. Convert array to list (modifiable)
        String[] fruits = {"Mango", "Orange", "Pineapple"};
        List<String> list6 = new ArrayList<>(Arrays.asList(fruits));
        list6.add("Guava");
        System.out.println("List6 (Array to List): " + list6);

        // 9. Sorting and reversing a list
        Collections.sort(list6);
        System.out.println("List6 sorted: " + list6);
        Collections.reverse(list6);
        System.out.println("List6 reversed: " + list6);
    }
}
