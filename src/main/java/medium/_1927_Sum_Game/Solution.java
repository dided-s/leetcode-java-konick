package medium._1927_Sum_Game;

import annotations.Medium;

@Medium
class Solution {

    public boolean sumGame(String num) {
        int firstSum = 0;
        int secondSum = 0;

        int firstQuestionCount = 0;
        int secondQuestionCount = 0;

        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) == '?') {
                firstQuestionCount++;
            } else {
                firstSum += (num.charAt(i) - '0');
            }
        }
        for (int i = num.length() / 2; i < num.length(); i++) {
            if (num.charAt(i) == '?') {
                secondQuestionCount++;
            } else {
                secondSum += (num.charAt(i) - '0');
            }
        }

        return firstSum + firstQuestionCount * 4.5 != secondSum + secondQuestionCount * 4.5;
    }
}