package leetcode;

import java.util.*;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class TwoPointersEx {

    public static boolean isPalindrome(String s) {
        int l = s.length();
        int i = 0;
        int j = l - 1;
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                if (i == j) return true;
            }
            while (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                if (i == j) return true;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        int l = s.length();
        int i = 0;
        int j = l - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                    return false;
                i++;
                j--;
            }

        }
        return true;
    }

    //медленно
    public static boolean isSubsequence2(String s, String t) {

        if (s.isEmpty()) return true;
        String regex = ".*" + String.join("+.*", s.split("")) + "+.*";

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(t).matches();
    }

    public static boolean isSubsequence3(String s, String t) {
        if (s.isEmpty()) return true;
        int index = 0;
        for (char c : t.toCharArray()) {
            if (index < s.length() && c == s.charAt(index)) {
                index++;
            }
        }
        return index == s.length();
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (index < s.length() && t.charAt(i) == s.charAt(index)) {
                index++;
            }
            if (index == s.length()) {
                return true;
            }
        }
        return false;
    }

    public int[] twoSum(int[] numbers, int target) {
        int j = 0;
        int i = numbers.length - 1;
        while (j < i) {
            if (target - numbers[i] > numbers[j]) {
                j++;
            } else if (target - numbers[j] < numbers[i]) {
                i--;
            } else {
                break;
            }
        }
        return new int[]{j + 1, i + 1};
    }

    public int maxArea(int[] height) {
        int i = height.length - 1;
        int j = 0;
        int max = (i - j) * Math.min(height[j], height[i]);
        while (j < i) {
            if (height[i] > height[j]) {
                int sq = (i - j) * Math.min(height[j], height[i]);
                if (sq > max)
                    max = sq;
                j++;
            } else if (height[i] < height[j]) {

                int sq = (i - j) * Math.min(height[j], height[i]);
                if (sq > max)
                    max = sq;
                i--;
            }
            if (height[i] == height[j]) {
                int sq = (i - j) * Math.min(height[j], height[i]);
                if (sq > max)
                    max = sq;

                i--;
                j++;
            }
        }

        return max;
    }

    public int maxArea2(int[] height) {
        int i = height.length - 1;
        int j = 0;
        int max = (i - j) * Math.min(height[j], height[i]);
        while (j < i) {
            if (height[i] > height[j]) {
                j++;
                if (height[j] > height[j - 1]) {
                    int sq = (i - j) * Math.min(height[j], height[i]);
                    if (sq > max)
                        max = sq;
                }
            } else if (height[i] < height[j]) {
                i--;
                if (height[i] > height[i + 1]) {
                    int sq = (i - j) * Math.min(height[j], height[i]);
                    if (sq > max)
                        max = sq;
                }

            } else {
                i--;
                j++;
                int sq = (i - j) * Math.min(height[j], height[i]);
                if (sq > max)
                    max = sq;
            }
        }

        return max;
    }

    public int maxArea3(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int j = 0; j < nums.length - 1 & nums[j] <= 0; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) continue;
            int i = nums.length - 1;
            int k = j + 1;
            while (i > k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    i--;
                } else if (sum < 0) {
                    k++;
                } else {
                    list.add(List.of(nums[j], nums[k], nums[i]));
                    i--;
                    k++;
                    while (nums[k] == nums[k - 1] && k < i) {
                        k++;
                    }
                }
            }
        }
        return list;
    }

    public List<String> summaryRanges(int[] nums) {
        int minIndex = 0;
        List<String> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (i - 1 == minIndex) {
                    res.add(String.valueOf(nums[minIndex]));
                } else {

                    res.add(nums[minIndex] + "->" + nums[i - 1]);
                }
                minIndex = i;
            }
        }

        if (nums.length - 1 == minIndex) {
            res.add(String.valueOf(nums[minIndex]));
        } else {

            res.add(nums[minIndex] + "->" + nums[nums.length - 1]);

        }
        return res;
    }

    private class IntervalsComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1];
        }
    }

    public Boolean canOverlap(int[] a, int[] b) {
        return a[0] <= b[0] && a[1] >= b[0];
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));

        Comparator<int[]> c = new IntervalsComparator();

        intervalList.sort(c);
        List<int[]> res = new ArrayList<>();

        int min = 0;
        for (int i = 0; i < intervalList.size(); ) {
            int[] minMaxValues = intervalList.get(i);
            while (i < intervalList.size() && canOverlap(minMaxValues, intervalList.get(i))) {
                minMaxValues[1] = Math.max(intervalList.get(i)[1], minMaxValues[1]);
                i++;
            }
            res.add(minMaxValues);
        }

        return res.toArray(new int[res.size()][]);
    }

//    public int[][] merge2(int[][] intervals) {
//        if (intervals.length <= 1)
//            return intervals;
//
//        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
////        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
//
//        List<int[]> result = new ArrayList<>();
//        int[] newInterval = intervals[0];
//        result.add(newInterval);
//        for (int[] interval : intervals) {
//            if (interval[0] <= newInterval[1])
//                newInterval[1] = Math.max(newInterval[1], interval[1]);
//            else {
//                newInterval = interval;
//                result.add(newInterval);
//            }
//        }
//
//        return result.toArray(new int[result.size()][]);
//    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0)
            return new int[][] { newInterval };

        List<int[]> result = new ArrayList<>();
        int i = 0;
        if (intervals[0][0] > newInterval[1]) {
            result.add(newInterval);
            while (i < intervals.length){
                result.add(intervals[i]);
                i++;
            }
        }
        if (intervals[intervals.length-1][1] < newInterval[0]){
            while (i < intervals.length){
                result.add(intervals[i]);
                i++;
            }
            result.add(newInterval);
        }

        while( i < intervals.length) {
            if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                while (i <intervals.length && intervals[i][0] <= newInterval[1]) {
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                    i++;
                }
                result.add(newInterval);
                while (i < intervals.length){
                    result.add(intervals[i]);
                    i++;
                }
                break;
            }
            else if (i>0 &&  intervals[i-1][1] < newInterval[0] && intervals[i][0] > newInterval[1]){
                result.add(newInterval);
                while (i < intervals.length){
                    result.add(intervals[i]);
                    i++;
                }
                break;
            }
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }




    public static void main(String[] args) {
    }
}
