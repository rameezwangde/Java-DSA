package GreedyAgo;

import java.util.Arrays;

class Job {
    int deadline, profit;

    Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequence {
    public static void main(String[] args) {
        // Example input
        Job[] arr = {
            new Job(2, 100),
            new Job(1, 19),
            new Job(2, 27),
            new Job(1, 25),
            new Job(3, 15)
        };

        int n = arr.length;
        int[] ans = JobScheduling(arr, n);

        System.out.println("Max Jobs Done: " + ans[0]);
        System.out.println("Max Profit: " + ans[1]);
    }

    static int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        int[] result = new int[maxi + 1];
        Arrays.fill(result, -1);

        int countJobs = 0, jobProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[]{countJobs, jobProfit};
    }
}

