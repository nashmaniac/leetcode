public class LeetcodeProblem70 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        for(int _a: arr) {
            System.out.printf("%d ", _a);
        }
        System.out.println();
        return arr[n];
    }

    public static void main(String[] args) {
        LeetcodeProblem70 l = new LeetcodeProblem70();

        l.climbStairs(5);
    }
}
