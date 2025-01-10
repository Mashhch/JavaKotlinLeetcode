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

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0;
        var ind = 1;
        for (i in 1..<nums.size) {
            if (nums[i] != nums[i - 1]) {
                nums[ind] = nums[i];
                ind++;
            }
        }
        return ind;
    }

    fun removeDuplicates2(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        var ind = 2
        for (index in 2..nums.size - 1) {
            if (nums[index] != nums[ind - 2]) {
                nums[ind] = nums[index];
                ind++
            }
        }
        return ind
    }

    fun majorityElement(nums: IntArray): Int {
        var value = nums[0];
        var count = 1;
        for (i in 1..<nums.size) {
            if (value == nums[i]) {
                count++
            } else {
                count--
                if (count == 0) {
                    value = nums[i]
                    count = 1
                }
            }
        }

        return value
    }

    fun rotate(nums: IntArray, k: Int): Unit {
        var _k = k % nums.size

        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, _k - 1)
        reverse(nums, _k, nums.size - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var _start = start
        var _end = end
        while (_start < _end) {
            nums.swap(_start, _end)
            _start++
            _end--
        }
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var maxDiff = 0
        for (i in prices.indices) {
            if (prices[i] < min) {
                min = prices[i]
            } else if (prices[i] - min > maxDiff) {
                maxDiff = prices[i] - min
            }

        }
        return maxDiff
    }

    fun maxProfit2(prices: IntArray): Int {
        var min = prices[0]
        var maxDiff = 0
        for (elem in prices) {
            if (elem < min) {
                min = elem
            } else if (elem - min > maxDiff) {
                maxDiff = elem - min
            }

        }
        return maxDiff
    }

    fun maxProfitV2(prices: IntArray): Int {
        var sum = 0;
        for (i in 1..<prices.size) {
            if (prices[i] > prices[i-1]) {
                sum +=prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    fun canJump(nums: IntArray): Boolean {
        var l = nums.size-1;
        for (j in l-1 downTo 0 ){
            if (l-j <= nums[j]) l = j;
        }

        return l == 0;
    }
}


