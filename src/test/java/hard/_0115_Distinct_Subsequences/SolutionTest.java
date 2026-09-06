package hard._0115_Distinct_Subsequences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, String t, int expected) {
        int actual = new Solution().numDistinct(s, t);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("rabbbit", "rabbit", 3),
                Arguments.of("babgbag", "bag", 5)
        );
    }
}