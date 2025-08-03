import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        try {
            System.out.println("=== Serialization ===");
            Person person = new Person("Diya", 30, new Address("123 Main St", "Chennai"));

            FileOutputStream fos = new FileOutputStream("File_Folder/person.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
            fos.close();
            System.out.println("Person object serialized successfully.");

            person.name = "Aksh";
            person.age = 21;
            person.address.street = "South street";
            person.address.city = "chennai";

            System.out.println("\n=== Deserialization ===");
            FileInputStream fis = new FileInputStream("File_Folder/person.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person desObj = (Person) ois.readObject();
            ois.close();
            fis.close();
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