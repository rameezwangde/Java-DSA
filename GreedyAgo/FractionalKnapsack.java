
package GreedyAgo;
import java.util.Arrays;
public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;

        double res = fractionalKnapsack(values, weights, W);
        System.out.println("Maximum value = " + res);
    }

    public static double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        double[][] ratioIndex = new double[n][2];

        for (int i = 0; i < n; i++) {
            ratioIndex[i][0] = i;
            ratioIndex[i][1] = (double) values[i] / weights[i];
        }

        Arrays.sort(ratioIndex, (a, b) -> Double.compare(b[1], a[1]));

        double totalValue = 0.0;
        int currentWeight = 0;

        for (int i = 0; i < n; i++) {
            int idx = (int) ratioIndex[i][0];

            if (currentWeight + weights[idx] <= W) {
                totalValue += values[idx];
                currentWeight += weights[idx];
            } else {
                int remain = W - currentWeight;
                totalValue += ((double) values[idx] / weights[idx]) * remain;
                break;
            }
        }

        return totalValue;
    }
}
