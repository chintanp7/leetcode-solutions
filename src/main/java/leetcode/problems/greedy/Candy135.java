package leetcode.problems.greedy;

import java.util.Arrays;

public class Candy135 {

    public static void main(String[] args) {
        Candy135 obj = new Candy135();
        int[] ratings = {3,2,1,4,3,4,4,2,1,3,5,7,4,6};
        //int[] ratings = {1,0,2};
        int totalCandies = obj.candy(ratings);
        System.out.println(totalCandies);
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int totalCandies = n;
        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }
            int currentPeak = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                currentPeak++;
                totalCandies += currentPeak;
                i++;
            }
            if (i == n) {
                return totalCandies;
            }
            int currentValley = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                currentValley++;
                totalCandies += currentValley;
                i++;
            }
            totalCandies -= Math.min(currentPeak, currentValley);
        }

        return totalCandies;
    }

    public int candy3(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        int totalCandies = 0;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }
        Arrays.stream(ratings).forEach(num -> System.out.print(num + " "));
        System.out.println();
        Arrays.stream(candies).forEach(num -> System.out.print(num + " "));
        return totalCandies;
    }

    public int candy2(int[] ratings) {
        int len = ratings.length;
        int totalCandies = 0;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        int direction = 0;
        int start = -1, end = -1;
        for (int i = 0; i < len; i++) {
            if ((i == 0 || ratings[i] < ratings[i - 1])
                    && (i == len - 1 || ratings[i] < ratings[i + 1])) {

                end = i;
                while (start < end - 1) {
                    if (ratings[start + 1] < ratings[end - 1]) {
                        if (start < 0) {
                            candies[start + 1] = 1;
                        } else {
                            candies[start + 1] = candies[start] + 1;
                        }
                        start++;
                        direction = 1;
                    } else if (ratings[start + 1] > ratings[end - 1]) {
                    //else {
                        if (end == len - 1) {
                            candies[end - 1] = 1;
                        } else {
                            candies[end - 1] = candies[end] + 1;
                        }
                        end--;
                        direction = -1;
                    } else {
                        if (start + 1 == end - 1) {
                            candies[start + 1] = candies[end];
                            start++;
                            end--;
                        } else {
                            if (direction > 0) {
                                candies[start + 1] = candies[start];
                                start++;
                            } else {
                                candies[end - 1] = candies[end];
                                end--;
                            }
                        }
                    }
                }
                start = i;
            }
        }
        for (int i = 0; i < len; i++) {
            totalCandies += candies[i];
        }
        Arrays.stream(ratings).forEach(num -> System.out.print(num + " "));
        System.out.println();
        Arrays.stream(candies).forEach(num -> System.out.print(num + " "));
        return totalCandies;
    }
}
