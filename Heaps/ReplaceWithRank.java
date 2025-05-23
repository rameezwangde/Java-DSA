package Heaps;

import java.util.*;

public class ReplaceWithRank {

    public static void main(String[] args) {
        int[] arr = {20, 15, 26, 2, 98, 6};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        int[] rankedArray = replaceWithRank(arr, arr.length);

        System.out.println("Ranked Array:");
        System.out.println(Arrays.toString(rankedArray));
    }

    static int[] replaceWithRank(int arr[], int N) {
        // Step 1: Push all elements into a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
        }

        // Step 2: Map each unique element to its 1-based rank
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        while (!minHeap.isEmpty()) {
            int val = minHeap.poll();
            if (!rankMap.containsKey(val)) {
                rankMap.put(val, rank++);
            }
        }

        // Step 3: Replace each element in the original array with its rank
        for (int i = 0; i < N; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}

