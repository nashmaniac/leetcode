package greedyAlgorithms;

public class MaxThief {
    public static int policeThief(char[] arr, int k) {
        int count = 0;
        if (arr.length == 0) {
            return count;
        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                int c = 0;
                int j = 0;
                while (j < k) {
                    if (i - j - 1 >= 0 && arr[i - j - 1] == 'T') {
                        c++;
                    }
                    if (i + j + 1 < n && arr[i + j + 1] == 'T') {
                        c++;
                    }
                    j++;
                }
                count = Math.max(count, c);
            }
        }
        return count;
    }
}
