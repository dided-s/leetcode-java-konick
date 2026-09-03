package medium._3876_Construct_Uniform_Parity_Array_II;

import annotations.Medium;

@Medium
public class Solution2 {

    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 == 1 && minOdd > nums1[i]) {
                minOdd = nums1[i];
            }
        }

        boolean canAllOdd = true;
        boolean canAllEven = true;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 == 0) {
                if (!(nums1[i] - minOdd >= 1)) {
                    canAllOdd = false;
                }
            } else {
                if (!(nums1[i] - minOdd >= 1)) {
                    canAllEven = false;
                }
            }

            if (!canAllOdd && !canAllEven) {
                return false;
            }
        }
        return true;
    }
}