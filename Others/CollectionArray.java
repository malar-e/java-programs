import java.util.*;
import java.time.*;
import java.util.Arrays;

public class CollectionArray {
    public static void main(String[] args) {
        List<Integer>[] array = new List[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<>();
        }

        for (List<Integer> list : array) {
            list.add(1);
            list.add(2);
            list.add(3);
        }

        for (int i=0;i<array.length;i++) {
            array[i].add(30);
            array[i].add(40);
            array[i].add(50);
        }

        array[0].add(70);
        array[1].add(80);
        array[2].add(90);
        array[3].add(100);
        array[4].add(110);

        for (List<Integer> list : array) {
            Collections.sort(list, Collections.reverseOrder());
        }

        Arrays.sort(array, (a, b) -> a.get(0).compareTo(b.get(0)));

        for (List<Integer> list : array) {
            System.out.println(list);
        }
       
        System.out.println();
        List<Object> objArray = new ArrayList<>();
        objArray.add("Hello");
        objArray.add(123);  
        objArray.add(45.67);
        objArray.add(LocalDate.now());
        for (Object obj : objArray) {
            System.out.println(obj);
        }

        List<Object> intArray = new ArrayList<>();
        intArray.add(10);
        intArray.add(2);
        intArray.add(3);

        List<Integer> intArray1 = new ArrayList<>();
        for (Object obj : intArray) {
            if(obj instanceof Integer) {
                intArray1.add((Integer) obj);
            }
        }

        Collections.sort(intArray1, Collections.reverseOrder());
        System.out.println(intArray1);

    }
}