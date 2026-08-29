package medium._2948_Make_Lexicographically_Smallest_Array_by_Swapping_Elements;

import annotations.Medium;

import java.util.*;

@Medium
public class Solution2 {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] groupArray = createGroupArray(nums, limit);

        //System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(groupArray));

        Set<Integer> groupSet = new HashSet<>();
        for (int i = 0; i < groupArray.length; i++) {
            groupSet.add(groupArray[i]);
        }

        int temp;
        for (int group : groupSet) {
            for (int i = 0; i < nums.length; i++) {
                if (groupArray[i] != group) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (groupArray[j] != group) continue;
                    if (nums[i] > nums[j]) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        return nums;
    }

    private int[] createGroupArray(int[] nums, int limit) {
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            edges.add(new ArrayList<>());
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    if (Math.abs(nums[i] - nums[j]) <= limit) {
                        edges.get(i).add(j);
                    }
                }
            }
        }

        //System.out.println(edges);

        int groupNumber = 1;
        int[] groupArray = new int[nums.length];
        Arrays.fill(groupArray, -1);

        for (int i = 0; i < groupArray.length; i++) {
            if (groupArray[i] == -1) {
                fillGroupArray(edges, groupArray, i, groupNumber);
                groupNumber++;
            }
        }

        return groupArray;
    }

    private void fillGroupArray(List<List<Integer>> edges, int[] groupArray, int index, int groupNumber) {
        if (groupArray[index] != -1) return;
        groupArray[index] = groupNumber;

        for (int edge : edges.get(index)) {
            fillGroupArray(edges, groupArray, edge, groupNumber);
        }
    }
}