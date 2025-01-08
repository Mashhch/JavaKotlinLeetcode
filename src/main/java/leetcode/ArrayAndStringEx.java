package leetcode;

public class ArrayAndStringEx {

    public static void rotate(int[] arr, int m) {
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
                rotate(nums1, i);
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
                rotate(nums1, i);
                nums1[i] = nums2[j];
                i++;
                m1++;
            } else if (nums1[i] <= nums2[j] & nums1[i + 1] >= nums2[j]) {
                rotate(nums1, i + 1);
                nums1[i + 1] = nums2[j];
                i++;
                j++;
                m1++;
            } else {
                i++;
            }
        }
    }

    public void MergeSortedArray2(int[] nums1, int m, int[] nums2, int n) {
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

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
