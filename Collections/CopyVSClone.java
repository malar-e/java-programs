public class CopyVSClone {
    public static void main(String[] args) {
        Person p1 = new Person("Malar");
        Person p2 = new Person(p1);  // using copy constructor
        System.out.println(p2.name); // Output: Malar

        Person p3 = null;

        try {
            p3 = (Person) p1.clone();  // using clone method
            System.out.println(p3.name); // Output: Malar
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        p1.name = "Updated Name";
        System.out.println(p2.name); // Output: Malar
        System.out.println(p3.name); // Output: Malar
    }
}

class Person implements Cloneable {
    String name;

    Person(String name) {
        this.name = name;
    }

    Person(Person other) {
        this.name = other.name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


