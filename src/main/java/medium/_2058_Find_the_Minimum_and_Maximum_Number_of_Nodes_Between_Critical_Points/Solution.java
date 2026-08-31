package medium._2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int index = 1;
        int firstIndex = -1;
        int lastIndex = -1;

        int minDistance = Integer.MAX_VALUE;

        while (head.next.next != null) {
            if ((head.val < head.next.val && head.next.val > head.next.next.val) ||
                    (head.val > head.next.val && head.next.val < head.next.next.val)) {
                if (firstIndex == -1) firstIndex = index;
                if (lastIndex != -1) {
                    int dist = index - lastIndex;
                    minDistance = Math.min(dist, minDistance);
                }
                lastIndex = index;
            }

            index++;
            head = head.next;
        }

        int maxDistance = lastIndex - firstIndex;

        if (maxDistance == 0)
            maxDistance = -1;

        if (minDistance == Integer.MAX_VALUE)
            minDistance = -1;

        return new int[]{minDistance, maxDistance};
    }
}