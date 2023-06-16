package BackTracking;
public class permutations {

    public static void findP(String str, String ans) {
        // Base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        // recursion - O(n)n!
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String NewStr = str.substring(0, i) + str.substring(i + 1);
            findP(NewStr, ans+curr);
        }
    }

    public static void main(String args[]) {
        String str = "abc";
        findP(str, "");
    }
}