package Hashing;
import java.util.*;

public class FindItinerary {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Banglore");
        map.put("Bombay", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        String start = "";
        for (String s : map.keySet()) {
            if (!map.containsValue(s)) {
                start = s;
                break;
            }
        }

        String to = map.get(start);
        while (to != null) {
            System.out.print(start + " -> " + to + ", ");
            start = to;
            to = map.get(to);
        }
    }
}
