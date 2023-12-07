package Hashing;
import java.util.*;

public class LinkedHashSet {
    public static void main(String[] args) {
        Set<String> set = new java.util.LinkedHashSet<>();
        set.add("Geeks");
        set.add("For");
        set.add("Geeks");
        set.add("Example");
        set.add("Set");
        System.out.println(set);
    }
}
