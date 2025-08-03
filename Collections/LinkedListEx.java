import java.util.*;
import java.util.Arrays;

public class LinkedListEx {
    public static void main(String[] args) {

        List<String> cars = new LinkedList<>();
        LinkedList<Integer> numbers = new LinkedList<>();
        LinkedList<Integer> numbersCopy = numbers; // Any changes made to one array will also affect the other
        LinkedList<String> brands = new LinkedList<>();

        System.out.println("=== LinkedList Methods ===");

        // Adding elements
        cars.add("Volvo");
        cars.add(1, "BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.add(4, "BMW");
        cars.add(null);

        brands.add("Toyota");
        brands.add("Honda");
        brands.add("Mahindra");
        brands.addAll(3, cars);
        brands.clear();
        brands.addAll(cars);
        brands.add("Toyota");
        brands.addFirst("Mahindra"); // addFirst() - only for LinkedList<>
        brands.addLast("RR");
        brands.offer("Benz"); // similar to add()
        brands.offerFirst("Porsche");
        brands.offerLast("Lexus");
        brands.push("Suzuki"); // similar to addFirst()

        // Cloning
        LinkedList brands2 = (LinkedList) brands.clone(); // clone() belongs to LinkedList<> class. we can't use it in a variable which is declared as List<>
        System.out.println("\nCars List: " + cars);
        System.out.println("Brands List: " + brands);
        System.out.println("Cloned Brands List: " + brands2);
        List brands3 = (LinkedList) brands.clone();
        System.out.println("Cloned Brands List: " + brands3);

        System.out.println("\nDoes brands contain 'Toyota'? " + brands.contains("Toyota"));

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
        System.out.print("\nBrands (using Descending Iterator): ");
        Iterator desItr = brands.descendingIterator(); // specific for LinkedList var
        while(desItr.hasNext()) {
            System.out.print(desItr.next() + " ");
        }

        System.out.println("\nElement() of brands: " + brands.element()); // similar to getFirst()
        System.out.println("getFirst() of brands: " + brands.getFirst());
        System.out.println("getLast() of brands: " + brands.getLast());

        System.out.println("peek() of brands: " + brands.peek()); // similar to getFirst()
        System.out.println("peekFirst() of brands: " + brands.peekFirst());
        System.out.println("peekLast() of brands: " + brands.peekLast());

        System.out.println("poll() of brands: " + brands.poll()); // poll() - retrieves and removes
        System.out.println("pollFirst() of brands: " + brands.pollFirst());
        System.out.println("pollLast() of brands: " + brands.pollLast());
        System.out.println("Brands: " + brands);
        System.out.println("pop() of brands: " + brands.pop()); // similar to removeFirst()
        System.out.println("removeFirst() of brands: " + brands.removeFirst()); 
        System.out.println("removeLast() of brands: " + brands.removeLast()); 
        brands.push("RR");
        System.out.println("Brands after pushing RR: " + brands);

        System.out.println("removeFirstOccurrence(\"BMW\") of brands: " + brands.removeFirstOccurrence("BMW")); 
        System.out.println("removeLastOccurrence(\"RR\") of brands: " + brands.removeLastOccurrence("RR")); 

        System.out.println("Brands: " + brands);
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
        LinkedList<String> cars2 = new LinkedList<>(List.of("Volvo", "BMW", "Ford", "Mazda", "Toyota"));
        LinkedList<String> valid = new LinkedList<>(List.of("Volvo", "Ford", "Mazda"));

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

        // Spliterator
        System.out.print("Spliterator traversal (st1): ");
        Spliterator<Integer> st1 = numbers.spliterator();
        while (st1.tryAdvance(n -> System.out.print(n + " ")));

        System.out.println();
        List<Integer> list = new ArrayList<>(numbers);
        Spliterator<Integer> st2 = numbers.spliterator();
        Spliterator<Integer> st3 = st2.trySplit();

        System.out.print("Spliterator st3 (first half): ");
        while (st3 != null && st3.tryAdvance(n -> System.out.print(n + " "))); // In LinkedList it did not split anything it takes all the elements from original spliterator.

        System.out.print("\nSpliterator st2 (second half): ");
        while (st2.tryAdvance(n -> System.out.print(n + " "))); // so prints nothing

        Spliterator<Integer> st4 = list.spliterator();
        Spliterator<Integer> st5 = st4.trySplit();

        System.out.print("\nSpliterator st5 (first half): ");
        while (st5 != null && st5.tryAdvance(n -> System.out.print(n + " ")));

        System.out.print("\nSpliterator st4 (second half): ");
        while (st4.tryAdvance(n -> System.out.print(n + " ")));

        System.out.println("\nequals(): " + numbers.equals(list));  // Both should be from same interface like List<> else return false - order and duplicates matters

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
