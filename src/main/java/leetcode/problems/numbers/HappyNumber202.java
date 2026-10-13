package leetcode.problems.numbers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {

    public static void main(String[] args) {
        final HappyNumber202 obj = new HappyNumber202();
        System.out.println(obj.isHappy(2));
    }

    public boolean isHappy(int n) {
        final Set<Integer> set = new HashSet<>();
        while (true) {
            if (set.contains(n)) {
                System.out.println(set.size());
                return false;
            }
            set.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (sum == 1) {
                System.out.println(set.size());
                return true;
            }
            n = sum;
        }
    }
}
