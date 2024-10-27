package leetcode.problems.arrays;

import java.util.*;

public class ThreeSum15 {

    public static void main(String[] args) {
        ThreeSum15 obj = new ThreeSum15();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(obj.threeSum4(nums));
    }

    public ArrayList<Object> threeSum4(int[] nums) {
        var result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final Set<List<Integer>> cache = new HashSet<>();
        final List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 && !cache.contains(List.of(nums[i], nums[j], nums[k]))) {
                        if (i != j && j != k) {
                            resultList.add(List.of(nums[i], nums[j], nums[k]));
                            cache.add(List.of(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return resultList;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int n =nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1,k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }else if(sum<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                }
            }
        }
        return result;
    }
}
