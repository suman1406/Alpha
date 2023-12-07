package Hashing;

public class TreeMap {
    public static void main(String[] args) {
        // Specify the generic types for TreeMap
        java.util.TreeMap<String, Integer> tm = new java.util.TreeMap<>();

        tm.put("India", 135);
        tm.put("China", 200);
        tm.put("Pak", 30);
        tm.put("US", 20);

        System.out.println(tm);
    }
}
