package leetcode.problems.dp;

public class Fibonacci2 {

    public int fibo(int num) {
        int[] ans = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            ans[i] = -1;
        }

        return fiboHelper(num, ans);
    }

    private int fiboHelper(int n, int[] ans) {
        if (n <= 1) {
            return n;
        }

        if (ans[n] != -1) {
            return ans[n];
        }

        int x = fiboHelper(n - 1, ans);
        int y = fiboHelper(n - 2, ans);

        ans[n] = x + y;
        return ans[n];
    }

    public static void main(String[] args) {
        Fibonacci2 obj = new Fibonacci2();
        int ans = obj.fibo(7);
        System.out.println(ans);
    }
}
