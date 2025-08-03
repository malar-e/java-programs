import java.io.*;

public class SerializationEx1 {
    public static void main(String[] args) {
        try {
            System.out.println("=== Serialization ===");
            Person person = new Person("Diya", 30, new Address("123 Main St", "Chennai"));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(person);
            oos.close();
            System.out.println("Person object serialized successfully.");

            person.name = "Aksh";
            person.age = 21;
            person.address.street = "South street";
            person.address.city = "chennai";

            byte[] serializedData = baos.toByteArray();
            System.out.println("Serialized data length: " + serializedData.length);

            System.out.println("\n=== Deserialization ===");
            ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Person desObj = (Person) ois.readObject();
            ois.close();
            bais.close();
            System.out.println("Person object deserialized successfully.\n");

            System.out.println("Name: " + desObj.name);
            System.out.println("Age: " + desObj.age);
            System.out.println("Salary: " + Person.salary);
            System.out.println("Salary: " + desObj.parents);
            System.out.println("Address: " + desObj.address.street + ", " + desObj.address.city + ", " + desObj.address.state);
        }
        catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    transient String name;
    int age;
    Address address;
    static int salary = 10000;
    final String parents = "Elangovan Chithra";

    public Person (String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        salary += 1000;
    }
}

class Address implements Serializable {
    private static final long serialVersionUID = 2L;
    transient String street;
    String city;
    transient final String state = "Tamil Nadu";

    public Address (String street, String city) {
        this.street = street;
        this.city = city;
    }
}