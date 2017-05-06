package NiukeAcm;

import java.util.Scanner;

/**
 * Created by TonyWu on 2017/5/3.
 * 动态规划DP经典问题
 * Dp本质：以空间换取时间
 * 问题描述：一个人上楼梯，要到达N层，但他每次可以走1到N之间任意一个数字的阶梯，求共有几种走法？
 * DP问题核心：状态转换方程 para[i] += para[i - j],其中j的范围是[1,N];
 */
public class ClimbFloor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //递归思路解法（暴力破解），时间复杂度高
        //System.out.println("递归暴力法" + JumpFloor(N));
        //Dp思想，找出状态转换方程，以空间换时间，时间复杂度低
        System.out.println("动态规划法" + Jump(N));

    }

    /**
     * 输入楼梯级数
     * 该解适用于每次只走1级楼梯或者2级楼梯
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if (target < 0) {
            return 0;
        }
        if (target <= 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /**
     * 输入楼梯级数
     * 解决一个人每次可以走1步到N（target）步的问题
     *
     * @param target
     * @return
     */
    public static int Jump(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int[] para = new int[target + 1];
        para[1] = 1;
        para[2] = 1 + 1;
        for (int i = 3; i <= target; i++) {
            para[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                para[i] += para[i - j];
            }
        }
        return para[target];
    }
}