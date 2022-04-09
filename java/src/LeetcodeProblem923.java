public class LeetcodeProblem923 {

    public static int threeSumMulti(int[] arr, int target) {
        int modulo = 1_000_000_007;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int c[] = new int[101];
            for (int j = i + 1; j < arr.length; j++) {
                int k = target - arr[i] - arr[j];
                if(k>=0 && k<=100 && c[k]>0) {
                    count += c[k];
                } 
                c[arr[j]]++;

            }
        }
        return count % modulo;
    }

    public static void main(String[] args) {
        System.out.println(threeSumMulti(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 }, 8));
        System.out.println(threeSumMulti(new int[] { 1, 1, 2, 2, 2, 2 }, 5));
    }

}
