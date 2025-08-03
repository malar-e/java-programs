import java.util.Arrays;
import java.util.*;
import java.util.Spliterator;
import java.util.stream.Stream;

public class ArrayMethods {
    public static void main(String[] args) {
        String[] strArray1 = new String[] {"apple", "cherry", "date", "banana"};
        String[] strArray2 = {"elderberry", "grape", "honeydew", "fig"}; // short cut of new string[] {}. we have to use it in initialization only.

        System.out.println("=== String Array 1 ===");
        for (String value : strArray1) {
            System.out.print(value + "\t");
        }
        System.out.println("\n\n=== String Array 2 ===");
        for (String value : strArray2) {
            System.out.print(value + "\t");
        }

        System.out.println("\n\nLength of Array 1: " + strArray1.length);
        System.out.println("Length of Array 2: " + strArray2.length);

        int comparison = Arrays.compare(strArray1, strArray2); // both arrays should be same type
        if (comparison < 0) {
            System.out.println("Array1 is less than Array2");
        } else if (comparison > 0) {
            System.out.println("Array1 is greater than Array2");
        } else {
            System.out.println("Array1 and Array2 are equal");
        }

        System.out.println("Array1 equals Array2: " + Arrays.equals(strArray1, strArray2));
        System.out.println("Mismatch index: " + Arrays.mismatch(strArray1, strArray2));
        System.out.println("HashCode of Array1: " + Arrays.hashCode(strArray1));

        System.out.println("\n=== Sorting Entire Array 1 ===");
        Arrays.sort(strArray1);
        System.out.println("Sorted Array 1: " + Arrays.toString(strArray1));

        System.out.println("\n=== Sorting Part of Array 2 (index 1 to 4) ===");
        Arrays.sort(strArray2, 1, 4);
        System.out.println("Partially Sorted Array 2: " + Arrays.toString(strArray2));

        Arrays.parallelSort(strArray2);
        System.out.println("\nParallel Sort Array 2: " + Arrays.toString(strArray2));

        System.out.println("\nBinary Search:");
        System.out.println("'apple' found at index: " + Arrays.binarySearch(strArray1, "apple"));
        System.out.println("'cherry' found at index (0 to 3): " + Arrays.binarySearch(strArray1, 0, 3, "cherry"));

        System.out.println("\n=== Cloning Arrays ===");
        String[] clonedArray = strArray1.clone();
        System.out.println("Cloned array == Original? " + (clonedArray == strArray1));
        System.out.println("Cloned array content: " + Arrays.toString(clonedArray));
        String[] copiedArray = Arrays.copyOf(strArray1, 10);
        System.out.println("Copy of Array 1 (length 10): " + Arrays.toString(copiedArray));
        System.out.println("Copied array == Original? " + (copiedArray == strArray1));
        System.out.println("Copy of Array 2 (index 0 to 3): " + Arrays.toString(Arrays.copyOfRange(strArray2, 0, 3)));

        System.out.println("\n=== Filling Array 1 with 'kiwi' ===");
        Arrays.fill(strArray1, "kiwi");
        System.out.println("Filled Array 1: " + Arrays.toString(strArray1));

        System.out.println("\n=== Filling first 3 elements of Array 2 with 'kiwi' ===");
        Arrays.fill(strArray2, 0, 3, "kiwi");
        System.out.println("Partially Filled Array 2: " + Arrays.toString(strArray2));

        System.out.println("\n=== Converting Arrays to Lists ===");
        List<String> list1 = Arrays.asList(strArray1);
        list1.set(1, "apple");
        System.out.println("Modified List1: " + list1);
        System.out.println("Backed Array (Array1): " + Arrays.toString(strArray1));

        List<String> list2 = Arrays.asList("A", "B", "C");
        list2.set(1, "D");
        System.out.println("List2: " + list2);

        List<String> list3 = new ArrayList<>(Arrays.asList(strArray2));
        list3.add("orange");
        System.out.println("Extended List3: " + list3);
        System.out.println("Original Array2: " + Arrays.toString(strArray2));

        Integer[] array = {1, 2, 3, 4, 5}; 
        System.out.println("\nArray: " + Arrays.toString(array));
        List<Integer> list4 = Arrays.asList(array); // we cant use primitive arrays
        list4.set(1, 6);
        System.out.println("Modified List4: " + list4);
        System.out.println("Backed Array (Array): " + Arrays.toString(array));

        System.out.println("\n=== Sorting with Comparator ===");
        Arrays.sort(array, 0, 3, (a, b) -> b - a);
        System.out.println("Partially Sorted Array: " + Arrays.toString(array));

        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("Fully Sorted (Descending): " + Arrays.toString(array));

        System.out.println("\n=== Printing with Spliterator ===");
        String[] names = {"Alice", "Bob", "Charlie", "Arun", "David"};
        Spliterator<String> spliterator1 = Arrays.spliterator(names);
        spliterator1.forEachRemaining(System.out::println);

        System.out.println("\n=== Spliterator (0 to 4) ===");
        Spliterator<String> spliterator2 = Arrays.spliterator(names, 0, 4);
        spliterator2.forEachRemaining(System.out::println);

        System.out.println("\n=== Using Streams ===");
        System.out.println("Names starting with 'A':");
        Stream<String> stream1 = Arrays.stream(names);
        stream1.filter(name -> name.startsWith("A")).forEach(System.out::println);  // filter - used to select elements which meets specific condition

        System.out.println("\nNames in Uppercase:");
        Stream<String> stream2 = Arrays.stream(names);
        stream2.map(String::toUpperCase).forEach(System.out::println); // map - used to transform the element

        Arrays.parallelPrefix(names, (s1, s2) -> s1 + " " + s2); // doing in parallel using multiple threads
        System.out.println("Parallel Prefix: " + Arrays.toString(names));

        Arrays.parallelPrefix(names, 0, 3, (s1, s2) -> s1 ); // doing in parallel using multiple threads
        System.out.println("Parallel Prefix (range 0 - 3): " + Arrays.toString(names));

        Arrays.parallelSetAll(names, i -> "Name" + i); // doing in parallel using multiple threads
        System.out.println("Parallel Set All: " + Arrays.toString(names));

        Arrays.setAll(names, i -> ("Name" + i).toUpperCase()); // doing sequentially - one element at a time
        System.out.println("Set All: " + Arrays.toString(names));

        System.out.println("\n=== Multi-Dimensional Array ==="); // deep for array of objects not for array of primitives like int[].
        int[][] mdArr1 = {{23, 45, 3}, {4, 5, 34}, {8, 98, 2}};
        int[][] mdArr2 = {{23, 45, 3}, {4, 5, 34}, {8, 98, 2}};
        System.out.println("MD Arrays equal? " + Arrays.equals(mdArr1, mdArr2)); // equals() checks reference for all the object arrays.
        System.out.println("MD Arrays equal? " + Arrays.deepEquals(mdArr1, mdArr2)); // for nested array deepEquals() checks values of elements, not reference.
        System.out.println("MD Array HashCode: " + Arrays.deepHashCode(mdArr1));
        System.out.println("MD Array toString: " + Arrays.deepToString(mdArr1));
    }
}
