package medium._2091_Removing_Minimum_and_Maximum_From_Array;

import annotations.Medium;

@Medium
public class Solution {

    public int minimumDeletions(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex) + 1;
        int right = nums.length - Math.max(minIndex, maxIndex);

        int middle = (nums.length - right) - left + 1;


        int min = Math.min(left, right);
        int max = Math.max(left, right);

        return min + Math.min(middle, max);
    }
}