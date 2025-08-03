import java.util.*;
import java.util.Arrays;

public class ComparatorExamples {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("zz", "Banana", "apple", "Mango", "fig", "Pineapple", "Kiwi");

        // a) Sort by length
        Comparator<String> byLength = Comparator.comparingInt(String::length);
        fruits.sort(byLength);
        System.out.println("Sorted by length: " + fruits);

        // b) Sort alphabetically (natural order)
        Comparator<String> natural = Comparator.naturalOrder();
        fruits.sort(natural);
        System.out.println("Sorted alphabetically: " + fruits);

        // c) Sort in reverse order
        Comparator<String> reverse = Comparator.reverseOrder();
        fruits.sort(reverse);
        System.out.println("Sorted in reverse: " + fruits);

        // d) Sort by last character
        Comparator<String> byLastChar = (s1, s2) -> {
            return Character.compare(
                s1.charAt(s1.length() - 1),
                s2.charAt(s2.length() - 1)
            );
        };
        fruits.sort(byLastChar);
        System.out.println("Sorted by last character: " + fruits);

        // e) Sort ignoring case
        Comparator<String> ignoreCase = Comparator.comparing(String::toLowerCase);
        fruits.sort(ignoreCase);
        System.out.println("Sorted ignoring case: " + fruits);

        // f) Chained comparator: first by length, then alphabetically (ignoring case)
        Comparator<String> lengthThenAlpha = Comparator
            .comparingInt(String::length)
            .thenComparing(str -> str.toLowerCase());
        fruits.sort(lengthThenAlpha);
        System.out.println("Sorted by length then alphabetically: " + fruits);
        fruits.sort(lengthThenAlpha.reversed());
        System.out.println("Sorted by length then alphabetically (reverse): " + fruits);

        // g) Use compare method manually
        String a = "Banana";
        String b = "Kiwi";
        int result = byLength.compare(a, b);
        System.out.println("Compare '" + a + "' and '" + b + "' by length: " + result);
    }
}
