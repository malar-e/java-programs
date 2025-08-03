import java.util.Arrays;
import java.util.*;

public class CompareObject {
    public static void main(String[] args) {
        Person[] p1 = { new Person("Alice", 25, new int[] {1, 2, 3}), new Person("Bon", 30, new int[] {4, 5, 6}) };
        Person[] p2 = { new Person("Alice", 27, new int[] {7, 8, 9}), new Person("Bob", 30, new int[] {10, 11, 12}) };

        System.out.println("Compare two objects: " + Arrays.compare(p1,p2));
        Arrays.sort(p1);
        System.out.println("Sort: " + Arrays.toString(p1));
        Arrays.sort(p1, Collections.reverseOrder());
        System.out.println("Sort (reverse): " + Arrays.toString(p1));

        List<Person> personList = new ArrayList<>(Arrays.asList(p2));
        personList.sort(null);
        System.out.println("Sort (List): " + personList);
        personList.sort(Collections.reverseOrder());
        System.out.println("Sort (List - reverse): " + personList);
    }
}

class Person implements Comparable<Person>{
    String name;
    int age;
    int[] arr;
    Person (String name, int age, int[] arr) {
        this.name = name;
        this.age = age;
        this.arr = arr;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Array: " + Arrays.toString(arr);
    }

    public int compareTo (Person obj) {
        int nameComparison = name.compareTo(obj.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        int ageComparison = Integer.compare(age, obj.age);
        if (ageComparison != 0) {
            return ageComparison;
        }
        return Arrays.compare(this.arr, obj.arr);
    }
}