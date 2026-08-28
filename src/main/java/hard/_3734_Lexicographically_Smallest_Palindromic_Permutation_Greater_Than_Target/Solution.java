package hard._3734_Lexicographically_Smallest_Palindromic_Permutation_Greater_Than_Target;

import annotations.Hard;

@Hard
public class Solution {

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = fillFreqArray(s);
        if (!isContainsPalindromicPermutation(freq)) {
            return "";
        }

        char[] answer = new char[n];
        int i = 0;

        int oddIndex = getOddIndex(freq);
        if (oddIndex != -1) {
            answer[n / 2] = (char) (oddIndex + 'a');
            freq[oddIndex]--;
        }

        // 1. Fill all same chars to Prefix
        while (i != n / 2) {
            char ch = target.charAt(i);

            if (freq[ch - 'a'] > 1) {
                answer[i] = target.charAt(i);
                answer[n - 1 - i] = answer[i];
                freq[target.charAt(i) - 'a'] -= 2;
                i++;
            } else {
                break;
            }
        }

        if (i == n / 2) {
            String answerString = new String(answer);
            if (answerString.compareTo(target) > 0) {
                return answerString;
            }
            if (n <= 2) return "";

            i--;
            freq[answer[i] - 'a'] += 2;
        }

        // 3. Find first bigger index. Then it will be lexicographically strictly greater permutation
        int biggerIndex = takeNextGreaterCharIndex(target.charAt(i), freq);
        while (biggerIndex == -1) {
            i--;
            if (i == -1) {
                return "";
            }
            freq[answer[i] - 'a'] += 2;
            biggerIndex = takeNextGreaterCharIndex(target.charAt(i), freq);
        }

        answer[i] = (char) (biggerIndex + 'a');
        answer[n - 1 - i] = answer[i];
        i++;

        // 4. Fill last chars
        for (int j = 0; j < 26; j++) {
            while (freq[j] > 1) {
                freq[j] -= 2;
                answer[i] = (char) (j + 'a');
                answer[n - 1 - i] = answer[i];
                i++;
            }
        }

        return new String(answer);
    }

    public int getOddIndex(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 != 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isContainsPalindromicPermutation(int[] freq) {
        int oddCount = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount > 1) return false;
        return true;
    }

    public int[] fillFreqArray(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
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