public class GenericInterface {
    public static void main(String[] args) {
        System.out.println("=== Generic Interface Example ===");
        MyClass<Integer> obj = new MyClass<>(new Integer[] {3, 5, 7, 10});
        System.out.println("Min: " + obj.min());
        System.out.println("Max: " + obj.max());
        MinMax<Double> obj2 = new MyClass<>(new Double[] {3.5, 5.5, 7.5, 10.5});
        System.out.println("\nMin: " + obj2.min());
        System.out.println("Max: " + obj2.max());

        MyClass<Person> obj3 = new MyClass<>(new Person[] {
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        });
        System.out.println("\nMin: " + obj3.min());
        System.out.println("Max: " + obj3.max());

    }
}

interface MinMax <T extends Comparable<T>> {
    T min();
    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] array;

    MyClass(T[] array) {
        this.array = array;
    }

    public T min() {
        T minValue = array[0];
        for (T value:array) {
            if(value.compareTo(minValue) < 0) {
                minValue = value;
            }
        }
        return minValue;
    }

    public T max() {
        T maxValue  = array[0];
        for (T value:array) {
            if(value.compareTo(maxValue) > 0) {
                maxValue = value;
            }
        }
        return maxValue;
    }
 }

 class Person implements Comparable<Person> {
    String name;
    int age;
    
    Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

 }