package medium._2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points;

import annotations.Explore;
import annotations.Medium;
import utils.ListNode;

@Medium
@Explore("Linked List")
public class Solution2 {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        Pair<Integer, ListNode> nextCriticalPoint;

        // Find first Critical Point
        nextCriticalPoint = getNextCriticalPointIndex(head);
        if (nextCriticalPoint.getOne() == -1) {
            return new int[]{-1, -1};
        }
        int firstCriticalIndex = nextCriticalPoint.getOne();
        head = nextCriticalPoint.getTwo();

        // Find second Critical Point
        nextCriticalPoint = getNextCriticalPointIndex(head);
        if (nextCriticalPoint.getOne() == -1) {
            return new int[]{-1, -1};
        }
        int nextCriticalIndex = firstCriticalIndex + nextCriticalPoint.getOne();
        head = nextCriticalPoint.getTwo();

        // Calculate first Min Distance
        int previousCriticalIndex = firstCriticalIndex;
        int minDistance = nextCriticalIndex - previousCriticalIndex;

        // Find Min Distance in loop
        previousCriticalIndex = nextCriticalIndex;
        while (true) {
            nextCriticalPoint = getNextCriticalPointIndex(head);
            if (nextCriticalPoint.getOne() == -1) {
                break;
            }

            nextCriticalIndex = previousCriticalIndex + nextCriticalPoint.getOne();
            head = nextCriticalPoint.getTwo();

            int currentDistance = nextCriticalIndex - previousCriticalIndex;
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
            }
            previousCriticalIndex = nextCriticalIndex;
        }

        int maxDistance = nextCriticalIndex - firstCriticalIndex;
        return new int[]{minDistance, maxDistance};
    }

    private Pair<Integer, ListNode> getNextCriticalPointIndex(ListNode head) {
        if (head == null || head.next == null) return new Pair<>(-1, null);
        int index = 1;

        while (head.next.next != null) {
            if (head.val < head.next.val && head.next.val > head.next.next.val)
                return new Pair<>(index, head.next);
            if (head.val > head.next.val && head.next.val < head.next.next.val)
                return new Pair<>(index, head.next);
            head = head.next;
            index++;
        }

        return new Pair<>(-1, null);
    }

    private static class Pair<ONE, TWO> {
        private final ONE one;
        private final TWO two;

        public Pair(ONE one, TWO two) {
            this.one = one;
            this.two = two;
        }

        public ONE getOne() {
            return one;
        }

        public TWO getTwo() {
            return two;
        }

        @Override
        public String toString() {
            return getOne() + ", " + getTwo();
        }
    }
}