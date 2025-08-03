import java.util.*;
import java.util.Arrays;

public class VectorEx {
    public static void main(String[] args) {

        List<String> cars = new Vector<>();
        Vector<Integer> numbers = new Vector<>();
        Vector<Integer> numbersCopy = numbers; // Any changes made to one array will also affect the other
        Vector<String> brands = new Vector<>();

        System.out.println("=== Vector Methods ===");

        // Adding elements
        cars.add("Volvo");
        cars.add(1, "BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.add(4, "BMW");
        cars.add(null);

        brands.addElement("Toyota"); // addElement() - only for Vector<>
        brands.insertElementAt("Honda", 0);
        brands.addElement("Mahindra");
        brands.insertElementAt("Honda", 1);
        brands.addAll(3, cars);
        brands.clear();
        brands.addAll(cars);
        brands.add("Toyota");
        brands.add("RR");

        // Cloning
        Vector brands2 = (Vector) brands.clone(); // // clone() belongs to Vector<> class. we can't use it in a variable which is declared as List<>
        System.out.println("\nCars List: " + cars);
        System.out.println("Brands List: " + brands);
        System.out.println("Cloned Brands List: " + brands2);
        List brands3 = (Vector) brands.clone();
        System.out.println("Cloned Brands List: " + brands3);

        System.out.println("\nDoes brands contain 'Toyota'? " + brands.contains("Toyota"));

        // ensureCapacity
        numbers.ensureCapacity(15);
        Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        System.out.println("\nOriginal Numbers List: " + numbers);
        System.out.print("Incremented Numbers (forEach): [");
        numbers.forEach(n -> System.out.print((n + 1) + ", "));
        System.out.println("]");

        System.out.println("Numbers after forEach (unchanged): " + numbers);

        // Accessing elements
        System.out.println("\nFirst element: " + numbers.get(0));
        System.out.println("Is numbers empty? " + numbers.isEmpty());
        System.out.println("Index of 'Toyota' in brands: " + brands.indexOf("Toyota"));

        // Iterators
        System.out.print("\nCars (using Iterator): ");
        Iterator<String> iterator = cars.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\nLast index of 'BMW' in cars: " + cars.lastIndexOf("BMW"));

        System.out.print("\nCars (using ListIterator forward): ");
        ListIterator<String> listIterator = cars.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

        System.out.print("\nCars (using ListIterator backward): ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }

        // Remove
        System.out.println("\nRemoved value at index 1? " + numbers.remove(1)); // by index
        System.out.println("Removed value 5? " + numbers.remove(Integer.valueOf(5))); // by object
        numbers.removeElementAt(0); // by index - returns void
        System.out.println("\n\nAfter removing elements from numbers: " + numbers);

        System.out.println("Removed all cars from brands? " + brands.removeAll(cars));
        cars.removeAll(cars);
        System.out.println("After removing all cars from brands: " + brands);
        System.out.println("After clearing cars list: " + cars);

        // Remove conditionally
        System.out.println("Removed even numbers? " + numbers.removeIf(n -> n % 2 == 0));
        System.out.println("After removing even numbers: " + numbers);

        // Replace
        numbers.replaceAll(n -> n + 1);
        System.out.println("After incrementing all numbers: " + numbers);

        // retainAll + removeIf
        Vector<String> cars2 = new Vector<>(List.of("Volvo", "BMW", "Ford", "Mazda", "Toyota"));
        Vector<String> valid = new Vector<>(List.of("Volvo", "Ford", "Mazda"));

        cars2.retainAll(valid);
        System.out.println("\nCars2 after retainAll(valid): " + cars2);

        cars2.add("BMW");
        cars2.add("Toyota");

        cars2.removeIf(car -> !valid.contains(car));
        System.out.println("Cars2 after removing invalid cars: " + cars2);

        // set
        System.out.println("Old element: "+cars2.set(1, "BMW"));
        cars2.set(2, "Audi");
        System.out.println("Cars2 after setting new values: " + cars2);
        System.out.println("Size of cars2: " + cars2.size());

        // sort, reverse, shuffle
        Collections.sort(cars2);
        System.out.println("Sorted cars2: " + cars2);
        System.out.println("Find index of \"BMW\" from cars2: " + Collections.binarySearch(cars2, "BMW"));  // collection should be sorted.
        Collections.sort(cars2, Collections.reverseOrder());
        System.out.println("Descending Sorted cars2: " + cars2);
        Collections.reverse(cars2);
        System.out.println("Reversed cars2: " + cars2);
        Collections.shuffle(cars2);
        System.out.println("Shuffled cars2: " + cars2);
        System.out.println("min of numbers: " + Collections.min(numbers));
        System.out.println("max of numbers: " + Collections.max(numbers));
        List<Integer> unmodList = Collections.unmodifiableList(numbers);
        System.out.println("Unmodifiable List: " + unmodList);

        Collections.sort(numbers, (a, b) -> b-a);
        System.out.println("Descending Sorted numbers: " + numbers);

        cars2.sort(null); // default sort
        System.out.println("Final sorted cars2: " + cars2);

        // subList
        List<String> subCars2 = cars2.subList(1, 3); // subList() - returns List<>
        System.out.println("Sublist of cars2 (1 to 3): " + subCars2);

        // toArray
        Object[] subArray = numbers.toArray();
        System.out.print("Numbers to Object array: ");
        for (Object value : subArray) {
            System.out.print(value + " ");
        }

        System.out.println();
        Integer[] subArray2 = new Integer[numbers.size()+1]; // if size is large enough, Java fills it and leaves extra elements as null.
        subArray2 = numbers.toArray(subArray2); // ArrayParam - to tell java to create the type of array
        String[] subArray3 = cars2.toArray(new String[0]); // if mentioned size is small, java ignores the size and fill the array with all list elements
        System.out.print("Numbers to Integer array: ");
        for (Integer value : subArray2) {
            System.out.print(value + " ");
        }
        System.out.println("\nCars2 to String Array: " + Arrays.toString(subArray3));

        // trimToSize
        System.out.println("\n\nBefore trimToSize: " + numbers);
        numbers.trimToSize();
        System.out.println("After trimToSize: " + numbers);

        // Spliterator
        System.out.print("Spliterator traversal (st1): ");
        Spliterator<Integer> st1 = numbers.spliterator();
        while (st1.tryAdvance(n -> System.out.print(n + " ")));

        System.out.println();
        Spliterator<Integer> st2 = numbers.spliterator();
        Spliterator<Integer> st3 = st2.trySplit();

        System.out.print("Spliterator st3 (first half): ");
        while (st3 != null && st3.tryAdvance(n -> System.out.print(n + " ")));

        System.out.print("\nSpliterator st2 (second half): ");
        while (st2.tryAdvance(n -> System.out.print(n + " ")));

        System.out.println("\nequals(): " + numbers.equals(brands));  // Both should be from same interface like List<> else return false - order and duplicates matters

        System.out.println("\nNumbers: " + numbers);
        System.out.println("Numbers Copy: " + numbersCopy);
        numbersCopy.add(100);
        System.out.println("Numbers after modifying copy: " + numbers);
        System.out.println("Numbers Copy after modification: " + numbersCopy);

        String str = numbersCopy.toString();
        System.out.println("Numbers Copy as String: " + str);
        System.out.println("Hashcode of Numbers Copy: " + numbersCopy.hashCode());

        System.out.println("\n=== End of Program ===");
    }
}
