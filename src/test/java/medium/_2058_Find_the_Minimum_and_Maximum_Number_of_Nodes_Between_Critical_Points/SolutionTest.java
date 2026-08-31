package medium._2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedListUtils;
import utils.ListNode;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(List<Integer> nodes, int[] expected) {
        ListNode head = LinkedListUtils.toListNode(nodes);

        int[] actual = new Solution().nodesBetweenCriticalPoints(head);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(List.of(3, 1), new int[]{-1, -1}),
                Arguments.of(List.of(5, 3, 1, 2, 5, 1, 2), new int[]{1, 3}),
                Arguments.of(List.of(1, 3, 2, 2, 3, 2, 2, 2, 7), new int[]{3, 3})
        );
    }
}