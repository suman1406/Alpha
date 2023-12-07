package Hashing;
import java.util.*;

public class HashSetCode {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        System.out.println(set);

        if(set.contains(2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        set.remove(30);

        System.out.println(set);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        int size = set.size();
        System.out.println(size);

        System.out.println();

        // using enhanced for loops
        for (Integer i : set) {
            System.out.println(i);
        }
        
    }
}
