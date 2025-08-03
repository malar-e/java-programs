// Comparator is used to customize the sorting logic only for objects

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;


public class ComparatorEx {
    public static void main(String[] args) {
        Integer[] array = {16, 2, 7, 4, 5};

        // Sort first 3 elements in descending order using Comparator
        Arrays.sort(array, 0, 3, Integer::compareTo);
        System.out.println("Partially sorted (0 to 2): " + Arrays.toString(array));

        // Sort full array in descending order using Comparator
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        System.out.println("Fully sorted: " + Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("Fully sorted: " + Arrays.toString(array));
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("Fully sorted (reverse): " + Arrays.toString(array));

        Person[] arrayPerson1 = { new Person ("Renuga", 28), new Person("Sachin", 25), new Person ("Sai", 29), new Person("Padma", 12)};
        Person[] arrayPerson2 = { new Person ("Renuga", 22), new Person("Sachin", 25), new Person ("Sai", 29), new Person("Padma", 12)};

        Arrays.sort(arrayPerson1, Comparator.comparingInt(p -> p.age));
        System.out.println(Arrays.toString(arrayPerson1));
        Arrays.sort(arrayPerson2, Comparator.comparing(p -> p.name));
        System.out.println(Arrays.toString(arrayPerson2));
        System.out.println("\nObject Arrays on comparison: " + Arrays.deepEquals(arrayPerson1, arrayPerson2));
        System.out.println("Hashcode od Object Array: " + Arrays.deepHashCode(arrayPerson1));
        System.out.println("toString(): " + Arrays.deepToString(arrayPerson1));

        System.out.println("\n=== sorting array of person object by name ===");
        Arrays.sort(arrayPerson1, Person::compareTo);

        for (Person obj : arrayPerson1) {
            System.out.println("name: " + obj.name + ", age: " + obj.age);
        }
        
        System.out.println("\n=== sorting array of person object by age ===");
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", 23));
        list.add(new Person ("Renuga", 22));
        list.add(new Person("Charlie", 21));
        list.add(new Person("Bob", 20));

        Collections.sort(list, Comparator.comparingInt(p -> p.age));
        for (Person obj : list) {
            System.out.println("name: " + obj.name + ", age: " + obj.age);
        }

        System.out.println("\n=== sorting array of person object by age ===");

        Collections.sort(list, new sortByAge());
        for (Person obj : list) {
            System.out.println("name: " + obj.name + ", age: " + obj.age);
        }

        System.out.println("\n=== sorting array of person object by name ===");
        list.sort(null); // uses comparator
        for (Person obj : list) {
            System.out.println("name: " + obj.name + ", age: " + obj.age);
        }

        System.out.println("\n=== sorting array of person object by name (reverse) ===");    
        list.sort(Collections.reverseOrder()); // uses comparable
        for (Person obj : list) {
            System.out.println("name: " + obj.name + ", age: " + obj.age);
        }

        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(array));
        stack.sort(Integer::compareTo);
        System.out.println("\nSorted stack: " + stack);

        Comparator<Integer> customComparator = new sortIntegers();
        Collections.sort(stack, customComparator);
        System.out.println("Custom sorted stack: " + stack);

        stack.sort(customComparator);
        System.out.println("Custom sorted list: " + stack);

    }
}

class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override // Java compares each object in the arrays using the .equals() method of the Person class. If you haven’t overridden the equals() method in Person, then it uses the default from Object class, which checks memory references (not field values).
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return this.age == other.age && this.name.equals(other.name);
    }

    @Override // same as equals()
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}

class sortByAge implements Comparator<Person> {
    public int compare(Person a, Person b) {
        return a.age-b.age;
    }
}

class sortIntegers implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        boolean isAeven = a % 2 == 0;
        boolean isBeven = b % 2 == 0;

        if(isAeven == isBeven) {
            if(a < b) return -1;
            if(a > b) return 1;
            return 0;
        }
        else {
            if(isAeven) {
                return -1;
            } else {
                return 1;
            }
        }

    }
}
