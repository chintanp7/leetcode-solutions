package leetcode.problems.dp;

public class Fibonacci {

    public int fibo(int num) {
        int[] ans = new int[num + 1];

        ans[0] = 0;
        ans[1] = 1;

        for (int i = 2; i <= num; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }

        return ans[num];
    }

    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        int ans = obj.fibo(7);
        System.out.println(ans);
    }
}
