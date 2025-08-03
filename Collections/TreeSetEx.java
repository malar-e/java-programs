import java.util.*;

public class TreeSetEx { // won't allow null values
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        Set<Integer> numbersCopy = new TreeSet<>();
        Set<String> cars = new TreeSet<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        
        numbersCopy.add(1);
        numbersCopy.add(10);
        numbersCopy.add(5);
        numbersCopy.add(8);
        numbersCopy.add(9);
        numbersCopy.add(2);
        numbersCopy.add(4);
        numbersCopy.add(3);
        numbersCopy.add(6);
        numbersCopy.add(7);
        
        cars.add("Toyota");
        cars.add("Honda");
        cars.add("Ford");

        Set<Integer> numbers1 = new TreeSet<>();
        numbers1.addAll(numbers);

        System.out.println("HashSet: " + numbers);
        System.out.println("HashSet Copy: " + numbersCopy);
        System.out.println("HashSet 1: " + numbers1);
        System.out.println("Removed 5? " + numbers.remove(5));
        System.out.println("HashSet contains 5? " + numbers.contains(5));
        System.out.println("HashSet after removing 5: " + numbers);
        System.out.println("HashSet size: " + numbers.size());
        System.out.println("Is HashSet empty? " + numbers.isEmpty());
        numbers.add(5);
        System.out.println("numbersCopy equals numbers? " + numbersCopy.equals(numbers)); // Both should be from same interface like Set<> else return false - content only matters
        System.out.println("cars equals numbers? " + cars.equals(numbers));


        System.out.print("Looping through HashSet:");
        cars.forEach(n -> System.out.print(n + " "));

        // We can't use some Collections methods and sort() on set.

        System.out.println("\nmin of cars: " + Collections.min(cars));
        System.out.println("max of cars: " + Collections.max(cars));
        Set<String> unmodSet = Collections.unmodifiableSet(cars);
        System.out.println("Unmodifiable Set: " + unmodSet);

        String str = cars.toString();
        System.out.println("\nCars as String: " + str);
        System.out.println("Hashcode of Cars: " + cars.hashCode());

        numbers.clear();

    }
}