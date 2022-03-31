package dp.knapsack;

public class SubsetSum {
    boolean canPartition(int[] num, int total) {
        int n = num.length;
        boolean[][] result = new boolean[n+1][total+1];

        for(int i=0;i<n+1;i++) {
            for(int j=0;j<total+1;j++) {
                if(i == 0) {
                    result[i][j] = false;
                }
                if(j == 0) {
                    result[i][j] = true;
                }
            }
        }

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<total+1;j++) {
                if(num[i-1]<=j) {
                    result[i][j] = result[i-1][j] || result[i-1][j-num[i-1]];
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        
        return result[n][total];
    }
}
