package leetcode.problems.greedy;

public class GasStation134 {

    public static void main(String[] args) {
        GasStation134 obj = new GasStation134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};
        //int[] gas = {4};
        //int[] cost = {4};
        System.out.println(obj.canCompleteCircuit2(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIdx = -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            int start = i;
            int totalDiff = 0;
            for (int j = 0; j < gas.length; j++) {
                totalDiff += gas[start] - cost[start];
                if (totalDiff < 0) {
                    break;
                }
                if (++start >= gas.length) {
                    start = 0;
                }
            }
            if (totalDiff >= 0) {
                startIdx = i;
                return startIdx;
            }
        }
        return startIdx;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }
}
