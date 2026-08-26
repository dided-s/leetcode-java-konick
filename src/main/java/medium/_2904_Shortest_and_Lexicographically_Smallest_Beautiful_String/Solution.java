package medium._2904_Shortest_and_Lexicographically_Smallest_Beautiful_String;

import annotations.Medium;

@Medium
public class Solution {

    public String shortestBeautifulSubstring(String s, int k) {
        if (s == null || s.length() < k) return "";

        int left = 0;
        int right = 0;
        int countUnit = 0;

        String answer = s;
        String temp;

        while (right < s.length()) {
            if (s.charAt(right) == '1') {
                countUnit++;
            }

            while (countUnit > k) {
                if (s.charAt(left) == '1') {
                    countUnit--;
                }
                left++;
            }
            while (left < right && s.charAt(left) == '0') {
                left++;
            }

            if (countUnit == k) {
                temp = s.substring(left, right + 1);

                if (temp.length() < answer.length() || (temp.length() == answer.length() && temp.compareTo(answer) < 0)) {
                    answer = temp;
                }
            }

            right++;
        }

        if (countUnit < k)
            return "";

        return answer;
    }
}