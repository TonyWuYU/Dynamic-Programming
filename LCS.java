package NiukeAcm;
import java.util.Scanner;
/**
 * Created by TonyWu on 2017/5/9.
 * 经典DP问题，最长公共子序列。
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 * 输入："1A2C3D4B56"  "B1D23CA45B6A"
 * 输出：  6
 * 解决思路：if (str1[i] == str2[j]) {
               dp[i][j] = (i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0) + 1;
          } else {
               dp[i][j] = Math.max(j - 1 < 0 ? 0 : dp[i][j - 1], i - 1 < 0 ? 0 : dp[i - 1][j]);
          }
 * 当str1[i] 和 str2[j] 相等时，那么的dp[i][j] = dp[i - 1][j - 1] + 1;
 * 如果str1[i] 和str2[j] 不相等时，那么dp[i][j] = max{dp[i - 1][j],dp[i][j - 1]}
 */
public class LCS {
    public static void main(String[] args) {
        new LCS().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.nextLine().toCharArray();
        char[] str2 = sc.nextLine().toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = (i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0) + 1;
                } else {
                    dp[i][j] = Math.max(j - 1 < 0 ? 0 : dp[i][j - 1], i - 1 < 0 ? 0 : dp[i - 1][j]);
                }

            }
        }
        System.out.println(dp[str1.length - 1][str2.length - 1]);
    }
}
