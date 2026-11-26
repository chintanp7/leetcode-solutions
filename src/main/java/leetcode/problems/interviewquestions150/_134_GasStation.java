package leetcode.problems.interviewquestions150;

public class _134_GasStation {
    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        _134_GasStation gasStation = new _134_GasStation();
        System.out.println("Can Reach: " + gasStation.canCompleteCircuit2(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int l = gas.length;
        for (int i = 0; i < l; i++) {
            int n = i;
            int c = 0;
            int totalGas = 0;
            int totalCost = 0;
            while (c < l) {
                totalGas += gas[n % l];
                totalGas -= cost[n % l];
                if (totalGas < 0) {
                    break;
                }
                n++;
                c++;
            }
            if (totalGas >= 0) {
                return totalGas;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {

        int n =  gas.length;
        int start = 0, surplus = 0, totalSurplus = 0;

        for (int i = 0; i < n; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }
        return totalSurplus < 0 ? -1 : start;
    }
}
