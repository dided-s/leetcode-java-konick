package hard._3734_Lexicographically_Smallest_Palindromic_Permutation_Greater_Than_Target;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, String target, String expected) {
        String actual = new Solution().lexPalindromicPermutation(s, target);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("baba", "abba", "baab"),
                Arguments.of("baba", "bbaa", ""),
                Arguments.of("abc", "abb", ""),
                Arguments.of("aac", "abb", "aca"),
                Arguments.of("a", "a", ""),
                Arguments.of("bb", "ba", "bb")
        );
    }
}