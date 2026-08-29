package medium._2948_Make_Lexicographically_Smallest_Array_by_Swapping_Elements;

import annotations.Medium;

import java.util.*;

@Medium
public class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);

        int currGroup = 0;
        Map<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        Map<Integer, Deque<Integer>> groupToList = new HashMap<>();
        groupToList.put(
                currGroup,
                new ArrayDeque<>()
        );
        groupToList.get(currGroup).add(numsSorted[0]);

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                // new group
                currGroup++;
            }

            // assign current element to group
            numToGroup.put(numsSorted[i], currGroup);

            // add element to sorted group list
            if (!groupToList.containsKey(currGroup)) {
                groupToList.put(currGroup, new LinkedList<>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }

        // iterate through input and overwrite each element with the next element in its corresponding group
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }

        return nums;
    }
}