import java.util.*;
import java.util.stream.*;
import java.util.Arrays;

public class StreamTerminalOperations {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>(Arrays.asList(
            "BMW", "Audi", "Mercedes", "Toyota", "Honda", "BMW", "Audi"
        ));


        System.out.println("=== Original List ===");
        System.out.println("Stream of cars: " + cars.stream());
        cars.forEach(System.out::println);

        // 1. anyMatch(): At least one element starts with 'T'
        boolean anyStartsWithT = cars.stream()
            .anyMatch(car -> car.startsWith("T"));
        System.out.println("\nAny car starts with T? " + anyStartsWithT);

        // 2. allMatch(): Do all cars have length > 2?
        boolean allLengthGreaterThan2 = cars.stream()
            .allMatch(car -> car.length() > 2);
        System.out.println("All car names length > 2? " + allLengthGreaterThan2);

        // 3. noneMatch(): No car starts with 'Z'
        boolean noneStartsWithZ = cars.stream()
            .noneMatch(car -> car.startsWith("Z"));
        System.out.println("No car starts with Z? " + noneStartsWithZ);

        // 4. collect(): Convert to Set to remove duplicates - Gives HashSet<>() by default
        Set<String> uniqueCars = cars.stream()
            .collect(Collectors.toSet());
        System.out.println("\nUnique Cars (using collect): " + uniqueCars);

        // toList(): Convert to List - gives ArrayList<>() by default
        List<String> carList = cars.stream()
            .collect(Collectors.toList()); 
        System.out.println("\nCars list: " + carList);

        // convert to queue
        Queue<String> queue = cars.stream()
            .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("\nCars Queue: " + queue);

        // Convert to Deque
        Deque<String> carDeque = cars.stream()
                                     .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println("Cars Deque: " + carDeque);

        // Convert to Stack
        Stack<String> carStack = cars.stream()
                                     .collect(Collectors.toCollection(Stack::new));
        System.out.println("Cars Stack: " + carStack);

        // Convert to TreeSet
        TreeSet<String> carTreeSet = cars.stream()
                                      .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Cars TreeSet: " + carTreeSet);

        // 5. count(): Total number of cars
        long totalCount = cars.stream().count();
        System.out.println("\nTotal cars: " + totalCount);

        // 6. findAny(): Get any one car
        Optional<String> anyCar = cars.stream().findAny();
        System.out.println("Any car: " + anyCar.orElse("None"));

        // 7. findFirst(): Get the first car
        Optional<String> firstCar = cars.stream().findFirst();
        System.out.println("First car: " + firstCar.orElse("None"));

        // 8. forEach(): Print each car (already shown above too)
        System.out.println("\nAll Cars using forEach:");
        cars.stream().forEach(System.out::println);

        // 9. min(): Find car with smallest length
        Optional<String> minLengthCar = cars.stream()
            .min(Comparator.comparingInt(String::length));
        System.out.println("Car with min length: " + minLengthCar.orElse("None"));

        // 10. max(): Find car with largest length
        Optional<String> maxLengthCar = cars.stream()
            .max(Comparator.comparing(String::toLowerCase));
        System.out.println("Car with max length: " + maxLengthCar.orElse("None"));

        // 11. reduce(): Concatenate all car names
        Optional<String> reduced = cars.stream()
            .reduce((a, b) -> a + ", " + b);
        System.out.println("Concatenated car names: " + reduced.orElse("Empty"));

        // 12. toArray(): Convert stream to array
        Object[] carArray = cars.stream().toArray();
        System.out.println("\nCars as Array: " + Arrays.toString(carArray));
    }
}
