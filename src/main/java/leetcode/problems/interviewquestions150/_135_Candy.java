package leetcode.problems.interviewquestions150;

import java.util.Arrays;

public class _135_Candy {

    public static void main(String[] args) {
        //int[] ratings = {1, 0, 2, 3, 4, 2, 0, 1, 1, 2, 3, 3, 1};
        //int[] ratings = {1, 2, 2};
        int[] ratings = {1,3,2,2,1};

        _135_Candy candy = new _135_Candy();
        System.out.println("Total candies req: " + candy.candy(ratings));
    }

    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int[] candies = new int[ratings.length];
        candies[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
                if (candies[i - 1] <= candies[i]) {
                    candies[i - 1] = candies[i - 1] + 1;
                }

            }
        }

        int totalCandies = Arrays.stream(candies).sum();
        return totalCandies;
    }
}
