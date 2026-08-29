package medium._2948_Make_Lexicographically_Smallest_Array_by_Swapping_Elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int limit, int[] expected) {
        int[] actual = new Solution().lexicographicallySmallestArray(nums, limit);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{1, 5, 3, 9, 8}, 2,
                        new int[]{1, 3, 5, 8, 9}),
                Arguments.of(
                        new int[]{1, 7, 6, 18, 2, 1}, 3,
                        new int[]{1, 6, 7, 18, 1, 2}),
                Arguments.of(
                        new int[]{1, 7, 28, 19, 10}, 3,
                        new int[]{1, 7, 28, 19, 10}),
                Arguments.of(
                        new int[]{5, 100, 44, 45, 16, 30, 14, 65, 83, 64}, 15,
                        new int[]{5, 100, 14, 16, 30, 44, 45, 64, 83, 65}),
                Arguments.of(
                        new int[]{7, 73, 1, 97, 13, 55, 74, 29, 76, 19},
                        14,
                        new int[]{1, 73, 7, 97, 13, 55, 74, 19, 76, 29}
                )
        );
    }
}