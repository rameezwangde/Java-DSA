package Heaps;

import java.util.PriorityQueue;

public class Operations {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);
        int smallest=minHeap.peek();
        System.out.println("Smallest element is: "+smallest);
        int removed=minHeap.poll();
        System.out.println("Removed element is: "+removed);
        boolean isEmpty=minHeap.isEmpty();
        System.out.println(isEmpty);
    }

}
