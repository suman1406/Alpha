package Hashing;

import java.util.HashMap;

public class Hash {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();
        System.out.println("Initial Map: " +hm);

        // Add
        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);
        System.out.println("After adding: " +hm);
        // Get
        System.out.println("Get: " +hm.get("a"));
        // Remove
        hm.remove("a");
        System.out.println("After removing: " +hm);
        // Contains
        System.out.println("Contains: " +hm.containsKey("a"));
        // Size
        System.out.println("Size: " +hm.size());
        // Iterate
        for (String key : hm.keySet()) {
            System.out.println("Key: " +key+ " Value: " +hm.get(key));
        }
        // Clear
        hm.clear();
        System.out.println("After clearing: " +hm);
        
    }
}
