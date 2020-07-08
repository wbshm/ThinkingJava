package demo.leetcode;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/6 8:55
 */
public class Solution {
    public static String longestPalindrome(String s) {
        int half = s.length() / 2;
        String max = "";
        int walk;
        int start, next;
        if (s.length() > 0) {
            max = s.substring(0, 1);
        }
        for (int i = 0; i <= half; i++) {
            boolean checkUpLimit = half + i + 1 < s.length();
            boolean checkDownLimit = half - i - 1 >= 0;
            if (checkUpLimit && s.charAt(half + i) == s.charAt(half + i + 1)) {
                start = half + i;
                next = half + i + 1;
                if ((s.length() - start) * 2 < max.length()) {
                    break;
                }
                max = check(s, start, next, max);
            }
            if (checkUpLimit && half + i - 1 >= 0 && s.charAt(half + i - 1) == s.charAt(half + i + 1)) {
                start = half + i - 1;
                next = half + i + 1;
                if (((s.length() - start) * 2) + 1 < max.length()) {
                    break;
                }
                max = check(s, start, next, max);
            }
            if (checkDownLimit && s.charAt(half - i - 1) == s.charAt(half - i)) {
                start = half - i - 1;
                next = half - i;
                if (next * 2 < max.length()) {
                    break;
                }
                max = check(s, start, next, max);
            }
            if (checkDownLimit && (half - i + 1) < s.length() && s.charAt(half - i - 1) == s.charAt(half - i + 1)) {
                start = half - i - 1;
                next = half - i + 1;
                if ((start + 1) * 2 + 1 < max.length()) {
                    break;
                }
                max = check(s, start, next, max);
            }
        }
        return max;
    }

    private static String check(String s, int start, int next, String max) {
        int walk = 0;
        while (s.charAt(start - walk) == s.charAt(next + walk)) {
            walk++;
            if (start - walk < 0 || next + walk >= s.length()) {
                break;
            }
        }
        walk = Math.max(walk - 1, 0);
        int length = next + walk - (start - walk) + 1;
        if (length > max.length()) {
            max = s.substring(start - walk, next + walk + 1);
        }
        return max;
    }

    public static String dynamicProgramming(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] check = new boolean[s.length()][s.length()];
        int length = 1;
        int start = 0;
        boolean success;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    success = check[i - 1][j + 1] || i - j < 3;
                    if (success) {
                        check[i][j] = true;
                        if (i - j + 1 > length) {
                            length = i - j + 1;
                            start = j;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        String aba = dynamicProgramming("aaa");
        System.out.println(aba);
    }
}
