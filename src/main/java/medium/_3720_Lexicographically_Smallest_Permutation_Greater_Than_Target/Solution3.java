package medium._3720_Lexicographically_Smallest_Permutation_Greater_Than_Target;

import annotations.Medium;

@Medium
public class Solution3 {

    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] answer = new char[s.length()];
        int i = 0;
        int biggerIndex;

        while (i != s.length()) {
            char ch = target.charAt(i);

            if (freq[ch - 'a'] > 0) {
                answer[i] = target.charAt(i);
                freq[target.charAt(i) - 'a']--;
                i++;
                continue;
            }

            biggerIndex = takeNextGreaterCharIndex(target.charAt(i), freq);
            while (biggerIndex == -1) {
                i--;
                if (i == -1) {
                    return "";
                }
                freq[answer[i] - 'a']++;
                biggerIndex = takeNextGreaterCharIndex(target.charAt(i), freq);
            }
            answer[i] = (char) (biggerIndex + 'a');
            i++;
            break;
        }

        if (i == s.length()) {
            i = s.length() - 1;
            freq[answer[i] - 'a']++;

            biggerIndex = takeNextGreaterCharIndex(target.charAt(i), freq);
            while (biggerIndex == -1) {
                i--;
                if (i == -1) {
                    return "";
                }
                freq[answer[i] - 'a']++;
                biggerIndex = takeNextGreaterCharIndex(target.charAt(i), freq);
            }
            answer[i] = (char) (biggerIndex + 'a');
            i++;
        }

        for (int j = 0; j < 26; j++) {
            while (freq[j] > 0) {
                freq[j]--;
                answer[i] = (char) (j + 'a');
                i++;
            }
        }

        return new String(answer);
    }

    private int takeNextGreaterCharIndex(char moreThanCh, int[] freq) {
        for (int i = moreThanCh - 'a' + 1; i < 26; ++i) {
            if (freq[i] > 0) {
                freq[i]--;
                return i;
            }
        }

        return -1;
    }
}