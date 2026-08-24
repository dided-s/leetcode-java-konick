package medium._1927_Sum_Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String num, boolean expected) {
        boolean actual = new Solution().sumGame(num);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("5023", false),
                Arguments.of("25??", true),
                Arguments.of("?3295???", false)
        );
    }
}