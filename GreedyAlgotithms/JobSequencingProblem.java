import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencingProblem {
    static class Job {
        int deadline;
        int profits;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profits = p;
        }
    }

    public static void main(String[] args) {
        // Job Sequencing Problem
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort jobs based on profits in descending order
        Collections.sort(jobs, Comparator.comparingInt(job -> -job.profits));

        // Print the sorted jobs
        for (Job job : jobs) {
            System.out.println("Job ID: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profits);
        }
    }
}
