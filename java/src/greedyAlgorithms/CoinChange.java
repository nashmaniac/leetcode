package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {
    // a public collection of available coins
    public static int[] coins = { 25, 10, 5, 1 };

    public static ArrayList<Integer> getMinCoins(int amount) // function to recieve change in the form of coins
    {
        ArrayList<Integer> change = new ArrayList<Integer>();
        Arrays.sort(coins);

        int remaining = amount;
        int curIndex = coins.length-1;
        while (remaining > 0 && curIndex >= 0) {
            if (coins[curIndex] <= remaining) {
                change.add(coins[curIndex]);
                remaining -= coins[curIndex];
            } else {
                curIndex--;
            }
        }
        if (remaining == 0) {
            return change;
        } else {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        System.out.println(getMinCoins(50).toString());
    }
}
