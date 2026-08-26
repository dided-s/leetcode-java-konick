package medium._2904_Shortest_and_Lexicographically_Smallest_Beautiful_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int k, String expected) {
        String actual = new Solution().shortestBeautifulSubstring(s, k);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("100011001", 3, "11001"),
                Arguments.of("1011", 2, "11"),
                Arguments.of("000", 1, ""),
                Arguments.of("11000111", 1, "1"),
                Arguments.of("001110101101101111", 10, "10101101101111")
        );
    }
}