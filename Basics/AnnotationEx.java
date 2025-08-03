import java.util.*;

public class AnnotationEx {
    public static void main(String[] args) {
        System.out.println("=== Annotation Example ===");

        System.out.println("@Override - Indicates that a method is overriding a superclass method.");
        System.out.println("@Deprecated - Marks a method as outdated, indicating it should not be used.");
        System.out.println("@SuppressWarnings - Instructs the compiler to suppress specific warnings.");

        oldMethod();
        uncheckedWarning();

    }

    @Deprecated // some IDE will give you an warning
    static void oldMethod(){
        System.out.println("This method is outdated.");
    }

    @SuppressWarnings("unchecked")
    static void uncheckedWarning(){
        List list = new ArrayList(); // raw type
        list.add(2);

        ArrayList<Integer> nums = (ArrayList<Integer>) list; // unchecked cast
        System.out.println(nums);
    }

}