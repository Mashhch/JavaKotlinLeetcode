package leetcode;

import java.util.Arrays;
import java.util.Objects;

public class ArrayAndStringEx {

    public static void rotate1(int[] arr, int m) {
        for (int i = arr.length - 1; i > m; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static void MergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int m1 = m - 1;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        while (i < m + n && j < n) {
            if (nums1[i] > nums2[j]) {
                rotate1(nums1, i);
                nums1[i] = nums2[j];
                j++;
                m1++;
            } else if (nums1[i] <= nums2[j] & i == m + n - 1) {
                nums1[i] = nums2[j];
                return;
            } else if (i == m1 & nums1[i] <= nums2[j]) {
                for (; j < n; j++) {
                    nums1[i + 1] = nums2[j];
                    i++;
                }
                return;
            } else if (i == m1 & nums1[i] > nums2[j]) {
                rotate1(nums1, i);
                nums1[i] = nums2[j];
                i++;
                m1++;
            } else if (nums1[i] <= nums2[j] & nums1[i + 1] >= nums2[j]) {
                rotate1(nums1, i + 1);
                nums1[i + 1] = nums2[j];
                i++;
                j++;
                m1++;
            } else {
                i++;
            }
        }
    }

    public static void MergeSortedArray2(int[] nums1, int m, int[] nums2, int n) {
        int midx = m - 1;
        int nidx = n - 1;
        int right = m + n - 1;

        while (nidx >= 0) {
            if (midx >= 0 && nums1[midx] > nums2[nidx]) {
                nums1[right] = nums1[midx];
                midx--;
            } else {
                nums1[right] = nums2[nidx];
                nidx--;
            }
            right--;
        }

    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == val ? 0 : 1;

        for (; i < j; i++) {
            while (nums[j] == val) {
                j--;
                if (i == j) return nums[i] == val ? i : i + 1;
            }
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
                if (i == j) return i + 1;
            }
        }
        return nums[i] == val ? i : i + 1;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int ind = 0;
        int val = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                ind++;
                nums[ind] = nums[i];
                val = nums[i];
            }
        }
        return ind + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int ind = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[ind] = nums[i];
                ind++;
            }
        }
        return ind;
    }

    public static int removeDuplicatesV2(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int ind = 0;
        int firstElemIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[ind]) {
                ind++;
                firstElemIndex = i;
                nums[ind] = nums[i];
            } else if (nums[i] == nums[ind] & firstElemIndex == i - 1) {
                ind++;
                nums[ind] = nums[i];
            }
        }
        return ind + 1;
    }

    public int removeDuplicatesV2_2(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int ind = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[ind - 2]) {
                nums[ind] = nums[i];
                ind++;
            }
        }
        return ind;
    }

    public static int majorityElement(int[] nums) {
        int value = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (value == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    value = nums[i];
                    count = 1;
                }
            }
        }

        return value;
    }


    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxDiff = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                min = prices[i];
                sum += maxDiff;
                maxDiff = 0;
            } else if (prices[i] - min > maxDiff) {
                maxDiff = prices[i] - min;
            }
        }
        return sum + maxDiff;
    }

    public int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public boolean canJump(int[] nums) {
        int l = nums.length - 1;
        for (int j = l - 1; j >= 0; j--) {
            if (l - j <= nums[j]) l = j;
        }

        return l == 0;
    }

    public int jump(int[] nums) {
        int iDist = 0;
        int i = 0;
        int inext = 0;
        int numJumps = 0;
        while (i < nums.length - 1) {
            int ind = 0;
            int maxDist = 0;
            for (int j = inext; j < nums.length && iDist > 0; j++) {
                if (maxDist < nums[j] + j) {
                    maxDist = nums[j] + j;
                    ind = j; //откуда можно прыгнуть дальше всего
                }
                iDist--;
            }
            //сдвигаем на следующий прыжок
            inext = ind + 1;
            iDist = nums[ind];
            i = nums[ind] + ind;
            numJumps++;
        }
        return numJumps;
    }

    public static String longestCommonPrefix(String[] strs) {
        int prefixLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < Math.min(prefixLength, strs[i].length()); j++) {
                if (strs[i - 1].charAt(j) != strs[i].charAt(j)) {
                    prefixLength = Math.min(prefixLength, j);
                    break;
                }
            }
            prefixLength = Math.min(prefixLength, strs[i].length());
        }

        return prefixLength == 0 ? "" : strs[0].substring(0, prefixLength);
    }

    public String longestCommonPrefix2(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { //if == 0, prefix matches the start of string
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }


    public String longestCommonPrefix3(String[] strs) {
        Arrays.sort(strs);
        for (int j = 0; j < Math.min(strs[0].length(), strs[strs.length - 1].length()); j++) {
            if (strs[0].charAt(j) != strs[strs.length - 1].charAt(j)) {
                return j == 0 ? "" : strs[0].substring(0, j);
            }
        }

        return strs[0].isEmpty() ? "" : strs[0];
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"aaa", "aa", "aaa"});
    }
}
