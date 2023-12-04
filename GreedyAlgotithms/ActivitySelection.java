import java.util.*;

public class ActivitySelection {

    public static void main(String args[]) {
        
        int start[] = {1,3,0,5,8,5};
        int finish[] = {2,4,6,7,9,9};
        
        //end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // sort
        int activities[][] = new int[start.length][3];
        for(int i = 0; i<start.length; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
            activities[i][2] = i;
        }

        //lambda function -> shortform
        Arrays.sort(activities, Comparator. comparingDouble(o -> o[2]));

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastend = activities[0][2];

        for(int i = 1; i<activities.length; i++) {
            if(activities[i][1] >= lastend) {
                maxAct++;
                ans.add(activities[i][0]);
                lastend = activities[i][2];
            }
        }

        System.out.println("Maximum activities: " + maxAct);
        System.out.println("Activities: " + ans);
                
    }
}
