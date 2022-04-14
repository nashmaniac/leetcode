package greedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static  class Item {
        int weight;
        int value;

        public Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }

        public int itemValue() {
            return this.weight *this.value;
        }
    }

    public static double fractionalKnapsack(int W, Item[] items, int n, int index)  {
        if(index == 0 || W == 0) {
            return 0;
        }
        
        int w = items[index-1].weight;
        int v = items[index-1].value;

        w = Math.min(W, w);
        double withTake = (w*v) + fractionalKnapsack(W-w, items, n, index-1);
        double withoutTake = fractionalKnapsack(W, items, n, index-1);
        
        return Math.max(withTake, withoutTake);
    }

    public static double fractionalKnapsack(int W, Item[] items, int n)  {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                int p1 = o1.value/o1.weight;
                int p2 = o2.value/o2.weight;

                return p1<p2 ? -1 : p1 == p2 ? 0: 1;
            }
        });

        return fractionalKnapsack(W, items, n, n);
    }

    public static void main(String[] args) {
        int n = 3;
        int W = 50;
        int[] values = new int[]{100,60,120};
        int[] weight = new int[]{20,10,30};
        Item[] items = new Item[n];

        for(int i=0;i<n;i++) {
            items[i] = new Item(weight[i], values[i]);
        }

        System.out.println(fractionalKnapsack(W, items, n));
    }
}
