class QuickStart {

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while(l<=r) {
            while(l<arr.length && (arr[l] != 'a' && arr[l] != 'e' && arr[l] != 'i' && arr[l] != 'o' && arr[l] != 'u' )) {
                l++;
        }
            while(r>=0 && (arr[r] != 'a' && arr[r] != 'e' && arr[r] != 'i' && arr[r] != 'o' && arr[r] != 'u' )) {
                r--;
}
            System.out.printf("%d %d\n", l, r);
            if(l<=r) {
                char t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }

            l++;
            r--;
            
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}