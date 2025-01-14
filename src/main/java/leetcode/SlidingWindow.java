package leetcode;

import java.util.Arrays;

public class SlidingWindow {
    public int minSubArrayLen_1(int target, int[] nums) {

        int sum = 0;
        int sumprev = 0;
        for (int k = 1; k <= nums.length; k++) {
            sum = sumprev + nums[k-1];
            sumprev = sum;
            if (sum >= target)
                return k;

            for (int i = 0, j = k; j < nums.length; j++, i++) {
                sum += nums[j] - nums[i];
                if (sum >= target)
                    return k;
            }
        }
        return 0;
    }

    public  int minSubArrayLen_2(int target, int[] nums) {

        if (Arrays.stream(nums).sum() < target)
            return 0;
        if (nums.length == 1) return 1;
        int kmax = nums.length;
        for (int k = nums.length / 2; k < nums.length && k > 0;) {

            int flag = 0;
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[j];
            }
            if (sum >= target) {
                kmax = k;
                k = (k + 1) / 2;
                flag = 1;
            }

            if (flag == 0) {
                for (int i = 0, j = k; j < nums.length; j++, i++) {
                    sum += nums[j] - nums[i];
                    if (sum >= target) {
                        kmax = k;
                        k = (k + 1) / 2;
                        flag = 1;
                        break;
                    }
                }
            }

            if (flag == 0) {
                if (kmax - 1 == k)
                    return kmax;
                if (1 == k)
                    return kmax;
                k = (kmax + k + 1) / 2;
            }

            if (k==kmax) return kmax;

        }
        return 0;
    }

    public int minSubArrayLen_22(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;

        while (end < nums.length) {
            sum += nums[end];

            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
    }
}
