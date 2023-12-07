package Hashing;
import java.util.*;

public class LinkedHashMapCode {
    public static void main(String[] args) {
        // Specify the generic types for LinkedHashMap
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 135);
        lhm.put("China", 200);
        lhm.put("Pak", 30);
        lhm.put("US", 20);

        System.out.println(lhm);
    }
}
