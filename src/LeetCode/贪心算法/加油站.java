package LeetCode.贪心算法;

public class 加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                startStation = i + 1;
                currentGas = 0;
            }
        }

        return totalGas >= 0 ? startStation : -1;
    }

}
