package hard._3116_Kth_Smallest_Amount_With_Single_Denomination_Combination;

import annotations.Hard;

import java.util.ArrayList;
import java.util.List;

@Hard
public class Solution {

    public long findKthSmallest(int[] coins, int k) {
        coins = reduceNums(coins);

        long number = -1;
        long left = 1;
        long right = Long.MAX_VALUE;
        long middle = 1;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (countDivisible(middle, coins) >= k) {
                number = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return number;
    }

    private static int[] reduceNums(int[] nums) {
        List<Integer> newNums = new ArrayList<>();
        for (int x : nums) {
            boolean flag = true;
            for (int y : newNums) {
                if (x % y == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                newNums.add(x);
            }
        }

        return newNums
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private static long countDivisible(long n, int... divisors) {
        int k = divisors.length;
        long result = 0;

        int pow2K = (1 << k);

        for (int mask = 1; mask < pow2K; mask++) {
            long currentLcm = 1;
            int selectedCount = 0;
            boolean valid = true;

            for (int i = 0; i < k; i++) {
                if ((mask & (1 << i)) != 0) {
                    selectedCount++;

                    currentLcm = lcm(currentLcm, divisors[i]);

                    if (currentLcm > n) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long multiples = n / currentLcm;

            if (selectedCount % 2 == 1) {
                result += multiples;
            } else {
                result -= multiples;
            }
        }

        return result;
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return a + b;
    }
}