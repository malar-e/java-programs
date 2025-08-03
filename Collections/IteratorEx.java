import java.util.*;

public class IteratorEx {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i); 
            numbers.add(i+2); 
        }
        Iterator<Integer> iterator1 = numbers.iterator();
        while (iterator1.hasNext()) {
            int i = iterator1.next();
            System.out.print(i + " ");
        }
        
        System.out.println();
        System.out.print("for each loop: ");
        for (Integer n : numbers) {
            System.out.print(n + " ");
            // numbers.remove(n); // will give ConcurrentModificationException
        }
        for (int i=0; i<numbers.size(); i++) { // after removing a element every elements goes one step back and the collection size() also decreases. so it will cause skipping some elements. 
            if(numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
        System.out.println("\nfor loop: " + numbers);
  
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if(i % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("Iterator: " + numbers);

        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("removeIf: " + numbers);

        LinkedHashMap<String, Integer> carPrices = new LinkedHashMap<>();
        carPrices.put("Nexus", 30000);
        carPrices.put("Honda", 28000);
        carPrices.put("Ford", 25000);
        System.out.println("\nCar Prices: " + carPrices);

        Iterator<Map.Entry<String, Integer>> entryIterator = carPrices.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println();
        Set<String> carKeys = carPrices.keySet();
        Iterator<String> keyIterator = carKeys.iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.println("Key: " + key);
        }
        System.out.println();
        Collection<Integer> carValues = carPrices.values();
        Iterator<Integer> valueIterator = carValues.iterator();
        while (valueIterator.hasNext()) {
            Integer value = valueIterator.next();
            System.out.println("Value: " + value);
        }
    }
}