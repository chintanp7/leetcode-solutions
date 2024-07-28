package leetcode.problems.twopointers;

public class TrappingWater42 {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingWater42 obj = new TrappingWater42();
        int water = obj.trap2(height);
        System.out.println(water);

    }

    public int trap2(int[] height) {
        int water = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        while (l < r) {
            int heightLeft = height[l];
            int heightRight = height[r];
            if (heightLeft > maxLeft) {
                maxLeft = heightLeft;
            }
            if (heightRight > maxRight) {
                maxRight = heightRight;
            }
            if (maxLeft < maxRight) {
                int currentWater = Math.min(maxLeft, maxRight) - height[l++];
                if (currentWater > 0) {
                    water += currentWater;
                }
            } else {
                int currentWater = Math.min(maxLeft, maxRight) - height[r--];
                if (currentWater > 0) {
                    water += currentWater;
                }
            }
        }
        return water;
    }

    public int trap(int[] height) {
        int totalWater = 0;
        // for each point, find max left and max right and find water at current point
        for (int p = 0; p < height.length; p++) {
            int maxLeft = 0;
            int leftP = p;
            while (leftP >= 0) {
                maxLeft = Math.max(maxLeft, height[leftP]);
                leftP--;
            }
            int maxRight = 0;
            int rightP = p;
            while (rightP < height.length) {
                maxRight = Math.max(maxRight, height[rightP]);
                rightP++;
            }
            int water = Math.min(maxLeft, maxRight) - height[p];
            if (water > 0) {
                totalWater += water;
            }
        }

        return totalWater;
    }
}
