class Solution {
    public double averageWaitingTime(int[][] customers) {
        int lastOrderCompleted = customers[0][0];
        double ans = 0;
        for (int[] arr : customers) {
            int arrivalTime = arr[0];
            int prepareTime = arr[1];
            int waitTime = prepareTime;
            if (arrivalTime < lastOrderCompleted) {
                waitTime = lastOrderCompleted + prepareTime - arrivalTime;
                lastOrderCompleted += prepareTime;
            }else{
                lastOrderCompleted = arrivalTime + waitTime ;
            }

            ans += waitTime;
        }

        return ans / customers.length;
    }////
}