import java.util.*;
import java.util.Arrays;

public class TreeMapEx { // Won't allow null key
    public static void main(String[] args) {
        TreeMap<String, Integer> carPrices = new TreeMap<>();
        carPrices.put("Toyota", null);
        carPrices.put("Nexus", 30000);
        carPrices.put("Honda", 28000);
        carPrices.put("Ford", 25000);
        System.out.println("Car Prices: " + carPrices);

        System.out.println("Price of Toyota: " + carPrices.get("Toyota")); // returns null since Toyota is not in the map
        System.out.println("Price of Nexus: " + carPrices.get("Nexus"));
        System.out.println("Removed Toyota? " + carPrices.remove("Toyota"));
        System.out.println("Removed nexus? " + carPrices.remove("Nexus"));
        System.out.println("Is Ford in the map? " + carPrices.containsKey("Ford"));
        System.out.println("Is price 28000 in the map? " + carPrices.containsValue(28000));
        System.out.println("Size of carPrices map: " + carPrices.size());
        System.out.println("isEmpty? " + carPrices.isEmpty());
        Map carPricesCopy1 = (TreeMap) carPrices.clone(); // clone() belongs to TreeMap<> class. we can't use it in a variable which is declared as Map<>
        Set<String> keys = carPrices.keySet();
        for (String key : keys) {
            System.out.println("Key: " + key + ", Value: " + carPrices.get(key));
        }
        Collection<Integer> values = carPrices.values();
        System.out.println("Values: " + values);

        carPrices.compute("Ford", (k, v) -> v + 10000);
        System.out.println("Updated Price of Ford: " + carPrices.get("Ford"));

        carPrices.computeIfPresent("Honda", (k, v) -> v + 20000);
        System.out.println("Updated Price of Honda: " + carPrices.get("Honda"));

        carPrices.computeIfAbsent("Toyota", (k) -> 20000);
        System.out.println("Updated Price of Toyota: " + carPrices.get("Toyota"));

        for (Map.Entry<String, Integer> entry : carPrices.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        carPrices.forEach((k,v) -> System.out.println("Key: " + k + ", Value: " + v));
        System.out.println("Get or default for BMW: " + carPrices.getOrDefault("BMW", 0));
        System.out.println("Get or default for Toyota: " + carPrices.getOrDefault("Toyota", 0));

        carPrices.merge("BMW", 40000, (n, p) -> p);
        carPrices.merge("Toyota", 20000, (n, p) -> p+10000);
        System.out.println("Updated Price of BMW: " + carPrices.get("BMW"));
        System.out.println("Updated Price of Toyota: " + carPrices.get("Toyota"));
        carPrices.forEach((k,v) -> System.out.println("Key: " + k + ", Value: " + v));

        Map<String, Integer> carPricesCopy2 = new TreeMap<>();
        carPricesCopy2.putAll(carPrices);
        carPricesCopy2.putIfAbsent("RR", 50000);
        carPricesCopy2.putIfAbsent("BMW", 50000);
        System.out.println("Car Prices Copy 2: " + carPricesCopy2);
        carPricesCopy2.replace("RR", 60000);
        System.out.println("BMW price replaced? "+carPricesCopy2.replace("BMW", 40000, 80000));
        System.out.println("Car Prices Copy 2: " + carPricesCopy2);

        carPricesCopy2.replaceAll((k, v) -> v+5);
        System.out.println("Car Prices Copy 2 after replaceAll: " + carPricesCopy2);

        // We can't use some Collections methods and sort() on map.

        System.out.println("\nmin of carPrices: " + Collections.min(carPrices.values()));
        System.out.println("max of cars: " + Collections.max(carPrices.keySet()));
        Map<String, Integer> unmodMap = Collections.unmodifiableMap(carPrices);
        System.out.println("Unmodifiable Map: " + unmodMap);

        System.out.println("equals(): " + carPrices.equals(carPricesCopy2)); // Both should be from same interface like Map<> else return false - content only matters
        String str = carPricesCopy2.toString();
        System.out.println("Car Prices Copy 2 as String: " + str);
        System.out.println("Hashcode of carPricesCopy2: " + carPricesCopy2.hashCode());
        carPrices.clear();
    }
}