class VersionControl {
    public boolean isBadVersion(int version) {
        return true;
    }
}
public class LeetcodeProblem278 extends VersionControl {
    public int firstBadVersion(int n) {
        int badVersion = n;
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(isBadVersion(mid+1)) {
                badVersion = Math.min(badVersion, mid+1);
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }

        return badVersion;
    }
}
