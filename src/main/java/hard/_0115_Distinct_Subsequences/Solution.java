package hard._0115_Distinct_Subsequences;

import annotations.Hard;
import annotations.Topic;

@Hard
@Topic("Combinatorics")
public class Solution {

    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }

        Integer[][] cache = new Integer[s.length() + 1][t.length() + 1];

        return numDistinct(s, t, s.length() - 1, t.length() - 1, cache);
    }

    public int numDistinct(String s, String t, int i, int j, Integer[][] cache) {
        // t length is done - we have one answer
        if (j == -1) return 1;
        // s length is done - we don't have answer
        if (i == -1) return 0;

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return cache[i][j] = numDistinct(s, t, i - 1, j - 1, cache) + numDistinct(s, t, i - 1, j, cache);
        } else {
            return cache[i][j] = numDistinct(s, t, i - 1, j, cache);
        }
    }
}