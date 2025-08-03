import java.util.*;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        Set<Integer> numbersCopy = new HashSet<>();
        Set<String> cars = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        numbers.add(null);
        
        numbersCopy.add(null);
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
        cars.add(null);

        Set<String> cars1 = new HashSet<>();
        cars1.addAll(cars);
        System.out.println("HashSet: " + numbers);
        System.out.println("HashSet Copy: " + numbersCopy);
        System.out.println("HashSet 1: " + cars1);
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
        cars.remove(null);

        // We can't use some Collections methods and sort() on set.

        System.out.println("\nmin of cars: " + Collections.min(cars));
        System.out.println("max of cars: " + Collections.max(cars));
        Set<String> unmodSet = Collections.unmodifiableSet(cars);
        System.out.println("Unmodifiable Set: " + unmodSet);

        String str = cars.toString();
        System.out.println("\nCars as String: " + str);
        System.out.println("Hashcode of Cars: " + cars.hashCode());

        for (String car : cars) {
            System.out.println("Car: " + car);
        }

        numbers.clear();

    }
}