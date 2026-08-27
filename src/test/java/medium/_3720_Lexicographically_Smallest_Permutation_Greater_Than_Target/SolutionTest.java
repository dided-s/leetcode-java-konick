package medium._3720_Lexicographically_Smallest_Permutation_Greater_Than_Target;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, String target, String expected) {
        String actual = new Solution().lexGreaterPermutation(s, target);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("abc", "bba", "bca"),
                Arguments.of("leet", "code", "eelt"),
                Arguments.of("baba", "bbaa", ""),
                Arguments.of("z", "a", "z"),
                Arguments.of("ab", "ab", "ba"),
                Arguments.of("a", "a", "")
        );
    }
}