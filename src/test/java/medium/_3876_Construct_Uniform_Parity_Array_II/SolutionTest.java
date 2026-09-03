package medium._3876_Construct_Uniform_Parity_Array_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums1, boolean expected) {
        boolean actual = new Solution().uniformArray(nums1);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 4, 7}, true),
                Arguments.of(new int[]{2, 3}, false),
                Arguments.of(new int[]{4, 6}, true)
        );
    }
}