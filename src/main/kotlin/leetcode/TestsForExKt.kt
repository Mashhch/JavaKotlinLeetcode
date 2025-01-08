package leetcode

class TestsForExKt {
    private fun arrayAndStringEx() {
        val obj = ArrayAndStringExKt()
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val nums2 = intArrayOf(2, 5, 6)

        obj.merge(nums1, 3, nums2, 3)
        println(nums1.joinToString(", "))
    }

    fun main() {
        arrayAndStringEx()
    }
}