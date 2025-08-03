import java.util.*;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Integer> numbersCopy = numbers; // Any changes made to one stack will also affect the other
        for (int i=1; i<=10; i++) {
            numbers.push(i);
        }
        numbers.push(null);
        
        Stack<Integer> numbers1 = new Stack<>();
        numbers1.addAll(numbers);

        System.out.println("Numbers in stack: " + numbers);
        System.out.println("Numbers in copy stack: " + numbers1);
        System.out.println("Top element: " + numbers.peek());
        System.out.println("Popped element: " + numbers.pop());
        System.out.println("Removed value at index 1? " + numbers.remove(1)); // by index
        System.out.println("Removed value 5? " + numbers.remove((Integer) 5));  // by object
        System.out.println("Size of stack: " + numbers.size());
        System.out.println("Is stack empty? " + numbers.isEmpty());
        System.out.println("Index of 6: " + numbers.search(6));
        System.out.print("Looping through numbers:");
        numbers.forEach(n -> System.out.print(n + " "));
        Collections.sort(numbers);
        System.out.println("\nSorted numbers: " + numbers);
        System.out.println("Find index of 1 from numbers: " + Collections.binarySearch(numbers, 1)); // collection should be sorted.
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending Sorted numbers: " + numbers);
        Collections.reverse(numbers);
        System.out.println("Reversed numbers: " + numbers);
        Collections.shuffle(numbers);
        System.out.println("Shuffled numbers: " + numbers);
        System.out.println("min of numbers: " + Collections.min(numbers));
        System.out.println("max of numbers: " + Collections.max(numbers));

        Collections.sort(numbers, (a, b) -> b-a);
        System.out.println("Descending Sorted numbers: " + numbers);

        numbers.sort(null); // default sort
        System.out.println("Final sorted numbers: " + numbers);

        System.out.print("Looping through numbers:");
        for (int value : numbers) {
            System.out.print(value + " ");
        }

        System.out.println("\nequals(): " + numbers.equals(numbersCopy)); // Both should be from same interface like Stack<> else return false - order and duplicates matters

        System.out.println("Numbers: " + numbers);
        System.out.println("Numbers Copy: " + numbersCopy);
        numbersCopy.push(10);
        System.out.println("Numbers after modifying copy: " + numbers);
        System.out.println("Numbers Copy after modification: " + numbersCopy);

        String str = numbersCopy.toString();
        System.out.println("Numbers Copy as String: " + str);
        System.out.println("Hashcode of Numbers Copy: " + numbersCopy.hashCode());

        numbers.clear();
    }
}