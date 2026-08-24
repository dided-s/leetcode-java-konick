package hard._1872_Stone_Game_VIII;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] stones, int expected) {
        int actual = new Solution().stoneGameVIII(stones);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{-1, 2, -3, 4, -5}, 5),
                Arguments.of(
                        new int[]{7, -6, 5, 10, 5, -2, -6}, 13),
                Arguments.of(
                        new int[]{-10, -12}, -22),
                Arguments.of(
                        new int[]{-10, -12, -10, -12}, 12)
        );
    }
}