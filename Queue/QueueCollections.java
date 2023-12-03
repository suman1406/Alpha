package Queue;
import java.util.*;

public class QueueCollections {
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q);
    }
}
