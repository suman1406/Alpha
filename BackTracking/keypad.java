package BackTracking;

// Keypad Combinations:

// Given a string containing digits from 2 to 9 inclusive, the task is to print all possible letter combinations that the number could represent. The answer can be printed in any order. A mapping of digits to letters, similar to telephone buttons, is given below. It is important to note that the digit 1 does not map to any letters.

// Mapping:
// 2 -> "abc"
// 3 -> "def"
// 4 -> "ghi"
// 5 -> "jkl"
// 6 -> "mno"
// 7 -> "pqrs"
// 8 -> "tuv"
// 9 -> "wxyz"

// Here are some sample inputs and their corresponding outputs:

// Sample Input 1: digits = "23"
// Sample Output 1: "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"

// Sample Input 2: digits = "2"
// Sample Output 2: "a", "b", "c"

// Sample Input 3: digits = ""
// Sample Output 3: ""

public class keypad {
    final static char[][]L= {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    
    public static void letterCombinations(String D) {
        int len = D.length();
        
        if( len == 0 ) {
            System.out.println("");
            return;
        }

        bfs(0, len, new StringBuilder(), D);
    }
    
    public static void bfs(int pos, int len , StringBuilder sb , String D ) {
        if( pos == len ) {
            System.out.println(sb.toString());
        } else {
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
            for( int i = 0; i<letters.length; i++ )
                bfs(pos+1 , len , new StringBuilder(sb).append(letters[i]) , D );
            }
        }
        
        public static void main( String args[]) {
            letterCombinations("2");
        }
}
