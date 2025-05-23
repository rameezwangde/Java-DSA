package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Least Interval: " + leastInterval(tasks, n)); // Output: 8
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }

        int totalTime = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int current = maxHeap.poll();
                if (current - 1 > 0) {
                    temp.add(current - 1);
                }
                totalTime++;
                cycle--;
            }

            for (int t : temp) {
                maxHeap.add(t);
            }

            if (!maxHeap.isEmpty()) {
                totalTime += cycle; // fill remaining time slots with idle if tasks are still left
            }
        }

        return totalTime;
    }
}

