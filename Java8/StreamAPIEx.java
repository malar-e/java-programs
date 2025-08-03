import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StreamAPIEx {
    public static void main (String[] args) {

        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream1 = stringList.stream();

        Stream<String> stream2 = Stream.of("one", "two", "three");

        Stream<String> concatStream = Stream.concat(stream1, stream2);

        List<String> stringsAsUppercaseList = concatStream
                .collect(Collectors.toList());

        System.out.println(stringsAsUppercaseList);

        Stream<String> pStream = stringList.parallelStream(); // supports all the operations like stream()
        pStream.forEach(n -> System.out.println("Value: " + n + ", Thread: " + Thread.currentThread().getName())); // split using spliterator and process in parallel using ForkJoinPool

        // Stream for map directly not applicable
        Map<String, Integer> map = Map.of(
            "Apple", 3,
            "Banana", 2,
            "Cherry", 5,
            "Date", 1
        );

        // 1. Stream over Map entries (key-value pairs)
        System.out.println("Entries with value > 2:");
        map.entrySet().stream()
            .filter(entry -> entry.getValue() > 2)
            .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        // 2. Stream over keys
        System.out.println("\nKeys:");
        map.keySet().stream()
            .forEach(System.out::println);

        // 3. Stream over values
        System.out.println("\nValues:");
        map.values().stream()
            .forEach(System.out::println);

        // 4. Convert keys, values, entries to List
        List<String> keyList = map.keySet().stream().collect(Collectors.toList());
        List<Integer> valueList = map.values().stream().collect(Collectors.toList());
        List<Map.Entry<String, Integer>> entryList = map.entrySet().stream().collect(Collectors.toList());

        System.out.println("\nKey List: " + keyList);
        System.out.println("Value List: " + valueList);
        System.out.println("Entry List: " + entryList);
        
    }
}