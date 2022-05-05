import java.util.*;
import java.util.LinkedList;

public class CustomSet {

    public static void main(String[] args) {
        // create ArrayList list1
        Set<String>
                list1 = new HashSet<>();

        // Add values in ArrayList
//        list1.add("p1");
//        list1.add("p2");
//        list1.add("p3");
        list1.add("p4");

        // print list 1
        System.out.println("List1: "
                + list1);

        // Create ArrayList list2
        Set<String>
                list2 = Set.of("p3", "p4", "p5", "p6");


        // print list 2
        System.out.println("List2: "
                + list2);

        // Find the common elements
        list1.retainAll(list2);

        // print list 1
        System.out.println("Common elements: "
                + list1);
    }
}
