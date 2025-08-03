import java.util.*;


public class HashWithObj {
    public static void main(String[] args) {
        HashMap<Student, Integer> map = new HashMap<>();
        map.put(new Student("Malar", 20), 1);
        map.put(new Student("Malar", 20), 2);

        System.out.println(map);

        HashSet<Student> set = new HashSet<>();
        set.add(new Student("Malar", 20));
        set.add(new Student("Malar", 20));

        System.out.println(set);

    }
}

class Student {
    String name;
    int age;

    Student (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        boolean nameEqual = this.name.equals(other.name);
        boolean ageEqual = this.age == other.age;
        return nameEqual && ageEqual;
    }

    @Override
    public String toString () {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}