package leetcode;

import java.util.Arrays;

import static leetcode.ArrayAndStringEx.MergeSortedArray;
import static leetcode.ArrayAndStringEx.removeElement;

public class TestsForEx {

    public static void MergeSortedArrayTest() {

//        int[] arr1 = new int[] {1,2,3,0,0,0};
//        int[] arr2 = new int[] {2,5,6};
//        int m = 3, n = 3;

        int[] arr1 = new int[] {4,0,0,0,0,0};
        int[] arr2 = new int[] {1,2,3,5,6};
        int m = 1, n = 5;

//        int[] arr1 = new int[]{7, 7, 7, 0, 0, 0};
//        int[] arr2 = new int[]{2, 5, 6};
//        int m = 3, n = 3;

//        int[] arr1 = new int[]{2, 0};
//        int[] arr2 = new int[]{1};
//        int m = 1, n = 1;
//
//        int[] arr1 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
//        int[] arr2 = new int[]{1, 2, 2};
//        int m = 6, n = 3;

//        int[] arr1 = new int[]{-1,-1,0,0,0,0};
//        int[] arr2 = new int[]{-1,0};
//        int m = 4, n = 2;

//        int[] arr1 = new int[]{-12,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        int[] arr2 = new int[]{-49,-45,-42,-41,-40,-39,-39,-39,-38,-36,-34,-34,-33,-33,-32,-31,-29,-28,-26,-26,-24,-21,-20,-20,-18,-16,-16,-14,-12,-11,-7,-6,-5,-4,-4,-3,-3,-2,-2,-1,0,0,0,2,2,6,7,7,8,10,10,13,13,15,15,16,17,17,19,19,20,20,20,21,21,22,22,24,24,25,26,27,29,30,30,30,35,36,36,36,37,39,40,41,42,45,46,46,46,47,48};
//        int m = 1, n = 91;
        MergeSortedArray(arr1, m, arr2, n);

        System.out.println(Arrays.toString(arr1));


    }

    public static void removeElementTest(){
//        int[] arr1 = new int[]{3,2,2,3};
//        int[] arr1 = new int[]{4,5};
        int[] arr1 = new int[]{2,2,3};
        System.out.println(removeElement(arr1, 2));
        System.out.println(Arrays.toString(arr1));
    }

    public static void main(String[] args){
//        MergeSortedArrayTest();
        removeElementTest();
    }
}
