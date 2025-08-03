import java.util.Arrays;

public class DeepEqualsDemo {
    public static void main(String[] args) {

        // 1. Primitive arrays
        int[] a1 = {1, 2};
        int[] b1 = {1, 2};
        System.out.println("Primitive arrays:");
        System.out.println(Arrays.equals(a1, b1));      // true
        System.out.println(Arrays.deepEquals(new Object[]{a1}, new Object[]{b1})); // true

        Integer[] a12 = {1, 2};
        Integer[] b12 = {1, 2};
        System.out.println("\nInteger arrays:");
        System.out.println(Arrays.equals(a12, b12));      // true
        System.out.println(Arrays.deepEquals(a12, b12)); // true

        // 2. Object array (String)
        String[] a2 = {"hi", "bye"};
        String[] b2 = {"hi", "bye"};
        System.out.println("\nString arrays:");
        System.out.println(Arrays.equals(a2, b2));      // true
        System.out.println(Arrays.deepEquals(a2, b2));  // true

        // 3. Custom object array (Person)
        Person[] a3 = { new Person("John"), new Person("Jane") };
        Person[] b3 = { new Person("John"), new Person("Jane") };
        System.out.println("\nCustom object arrays:");
        System.out.println(Arrays.equals(a3, b3));      // true only if equals() is overridden
        System.out.println(Arrays.deepEquals(a3, b3));  // true only if equals() is overridden

        // 4. Nested object arrays
        Person[][] a4 = { { new Person("Tom") } };
        Person[][] b4 = { { new Person("Tom") } };
        System.out.println("\nNested object arrays:");
        System.out.println(Arrays.equals(a4, b4));      // false
        System.out.println(Arrays.deepEquals(a4, b4));  // true only if equals() is overridden

        // 1. Object[] with Strings
        Object[] strArray1 = { "apple", "banana" };
        Object[] strArray2 = { "apple", "banana" };

        System.out.println("String Array:");
        System.out.println("equals: " + Arrays.equals(strArray1, strArray2));        // true
        System.out.println("deepEquals: " + Arrays.deepEquals(strArray1, strArray2)); // true
        System.out.println();

        // 2. Object[] with custom objects (Person)
        Object[] personArray1 = { new Person("Alice") };
        Object[] personArray2 = { new Person("Alice") };

        System.out.println("Custom Object Array:");
        System.out.println("equals: " + Arrays.equals(personArray1, personArray2));        // false (if no equals())
        System.out.println("deepEquals: " + Arrays.deepEquals(personArray1, personArray2)); // true (if equals() overridden)
        System.out.println();

        // 3. Object[] with nested array
        Object[] nestedArray1 = { new String[] { "x", "y" } };
        Object[] nestedArray2 = { new String[] { "x", "y" } };

        System.out.println("Nested Array:");
        System.out.println("equals: " + Arrays.equals(nestedArray1, nestedArray2));        // false
        System.out.println("deepEquals: " + Arrays.deepEquals(nestedArray1, nestedArray2)); // true
        System.out.println();

        // 4. Mixed-type object arrays
        Object[] mixed1 = { "hello", new Person("Bob"), new String[]{"a", "b"} };
        Object[] mixed2 = { "hello", new Person("Bob"), new String[]{"a", "b"} };

        System.out.println("Mixed Array:");
        System.out.println("equals: " + Arrays.equals(mixed1, mixed2));        // false
        System.out.println("deepEquals: " + Arrays.deepEquals(mixed1, mixed2)); // true (if Person has equals())
    }
}


class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person p = (Person) obj;
        return name.equals(p.name);
    }

    @Override
    public String toString() {
        return name;
    }
}