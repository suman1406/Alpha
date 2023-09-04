import java.util.*;

public class MyArrayList {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String args[]) {
        // Java Collection Framework
        // Defining ArrayList =>
        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<String> list2 = new ArrayList<>();
        // ArrayList<Boolean> list3 = new ArrayList<>();

        //add
        list.add(1); // O(1)
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(1, 9);

        System.out.println(list);

        //Get Operation
        int element = list.get(2);
        System.out.println(element);

        //Delete
        list.remove(2);
        System.out.println(list);

        //Set
        list.set(2, 10);
        System.out.println(list);

        //contains
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        //size of the ArrayList
        System.out.println(list.size());

        //Reverse AL
        for(int i = list.size()-1; i>=0; i--){
            System.out.println(list.get(i) + " ");
        }
        System.out.println();

        //Find Max
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++) {
            if(max < list.get(i)) {
                max = list.get(i);
            }
            //Writing in a single line
            // max = Math.max(max, list.get(i));
        }
        System.out.println("Max element = " + max);

        //Sorting ascending
        Collections.sort(list);

        //Sorting Desc
        Collections.sort(list, Collections.reverseOrder());
        // Comparator - fnx logic
    }
}
