package leetcode

class ArrayAndStringExKt {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]
                i--
            } else {
                nums1[k] = nums2[j]
                j--
            }
            k--
        }
    }

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0;
        for (index in nums.indices) {
            if (nums[index] != `val`) {
                nums[i] = nums[index]
                i++
            }
        }
        return i
    }
}

