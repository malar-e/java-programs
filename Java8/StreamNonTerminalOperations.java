import java.util.*;
import java.util.stream.*;
import java.util.Arrays;

public class StreamNonTerminalOperations {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Mercedes");
        cars.add("Toyota");
        cars.add("Honda");
        cars.add("BMW"); // duplicate
        cars.add("Audi"); // duplicate

        System.out.println("Stream of cars: " + cars.stream());

        // 1. map(): Convert to uppercase and print
        System.out.println("Uppercased:");
        cars.stream()
            .map(String::toUpperCase)
            .forEach(System.out::println);

        // 2. filter(): Cars starting with 'A'
        System.out.println("\nStarts with A:");
        cars.stream()
            .filter(car -> car.startsWith("A"))
            .forEach(System.out::println);

        // 3. distinct(): Remove duplicates
        System.out.println("\nDistinct Cars:");
        cars.stream()
            .distinct()
            .forEach(System.out::println);

        // 4. limit(): Only the first 3 elements
        System.out.println("\nLimit to first 3:");
        cars.stream()
            .limit(3)
            .forEach(System.out::println);

        // 5. peek(): Debug/log each element before filtering
        System.out.println("\nUsing peek:");
        cars.stream()
            .peek(car -> System.out.println("Before filter: " + car))
            .filter(car -> car.length() > 4)
            .peek(car -> System.out.println("After filter: " + car))
            .forEach(System.out::println);

        // 6. flatMap(): Convert List<List<String>> to Stream<String>
        System.out.println("\nUsing flatMap:");
        List<String> luxury = Arrays.asList("BMW", "Audi");
        List<String> economy = Arrays.asList("Toyota", "Honda");
        List<List<String>> allCars = Arrays.asList(luxury, economy);

        allCars.stream()
            .flatMap(List::stream)  // flattens List<List<String>> to Stream<String> - flatMap(list -> list.stream())
            .map(value -> value.toUpperCase())
            .forEach(System.out::println);
    }
}
