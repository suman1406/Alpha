package Stack;
import java.util.*;

public class StackCollections {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
