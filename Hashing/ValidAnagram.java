package Hashing;
import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int of = map.get(ch);
                int nf = of+1;
                map.put(ch,nf);
            }else{
                map.put(ch,1);
            }
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch)){
                int of = map.get(ch);
                int nf = of-1;
                if(nf == 0){
                    map.remove(ch);
                }else{
                    map.put(ch,nf);
                }
            }else{
                return false;
            }
        }

        return true;
    }
}