package Algorithms.Daily.WeekOne.PartOne;

import java.util.Scanner;

//快手2020春

/**
 * 多多鸡有N个魔术盒子（编号1～N），其中编号为i的盒子里有i个球。
 * 多多鸡让皮皮虾每次选择一个数字X（1 <= X <= N），多多鸡就会把球数量大于等于X个的盒子里的球减少X个。
 * 通过观察，皮皮虾已经掌握了其中的奥秘，并且发现只要通过一定的操作顺序，可以用最少的次数将所有盒子里的球变没。
 * 那么请问聪明的你，是否已经知道了应该如何操作呢？
 */

/**
 * 输入描述:
 *
 * 第一行，有1个整数T，表示测试用例的组数。
 * （1 <= T <= 100）
 * 接下来T行，每行1个整数N，表示有N个魔术盒子。
 * （1 <= N <= 1,000,000,000
 */

/**
 * 输出描述:
 *
 * 共T行，每行1个整数，表示要将所有盒子的球变没，最少需要进行多少次操作。
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0;i<num;i++){
            int n = sc.nextInt();
            System.out.println(cal(n));
        }

    }

    public static int cal(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        else return 1+cal(n/2);
    }
}
