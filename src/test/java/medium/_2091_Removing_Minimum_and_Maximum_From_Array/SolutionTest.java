package medium._2091_Removing_Minimum_and_Maximum_From_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int expected) {
        int actual = new Solution().minimumDeletions(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{2, 10, 7, 5, 4, 1, 8, 6}, 5),
                Arguments.of(
                        new int[]{0, -4, 19, 1, 8, -2, -3, 5}, 3),
                Arguments.of(
                        new int[]{101}, 1)
        );
    }
}