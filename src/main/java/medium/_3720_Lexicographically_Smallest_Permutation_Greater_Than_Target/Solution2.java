package medium._3720_Lexicographically_Smallest_Permutation_Greater_Than_Target;

import annotations.Medium;

@Medium
public class Solution2 {

    public String lexGreaterPermutation(String s, String target) {
        int[] freqS = new int[26];
        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }

        char[] answer = new char[s.length()];
        int i = 0;
        int foundIndex;

        while (i != s.length()) {
            if (freqS[target.charAt(i) - 'a'] > 0) {
                answer[i] = target.charAt(i);
                freqS[target.charAt(i) - 'a']--;
            } else {
                while ((foundIndex = foundIndex(target.charAt(i), freqS)) == -1) {
                    i--;
                    if (i == -1) {
                        return "";
                    }
                    freqS[answer[i] - 'a']++;
                }
                answer[i] = (char) (foundIndex + 'a');
                i++;
                break;
            }
            i++;
        }

        if (new String(answer).equals(target)) {
            i = s.length() - 1;
            freqS[answer[i] - 'a']++;

            while ((foundIndex = foundIndex(target.charAt(i), freqS)) == -1) {
                i--;
                if (i == -1) {
                    return "";
                }
                freqS[answer[i] - 'a']++;
            }
            answer[i] = (char) (foundIndex + 'a');
            i++;
        }

        for (int j = 0; j < 26; j++) {
            while (freqS[j] > 0) {
                freqS[j]--;
                answer[i] = (char) (j + 'a');
                i++;
            }
        }

        return new String(answer);
    }

    private int foundIndex(char moreThanCh, int[] freq) {
        for (int i = moreThanCh - 'a' + 1; i < 26; ++i) {
            if (freq[i] > 0) {
                freq[i]--;
                return i;
            }
        }

        return -1;
    }
}