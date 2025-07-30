class Solution {
    // int[] d, c, cache;

    public int mincostTickets(int[] days, int[] costs) {
        // d = days;
        // c = costs;
        int n = days.length ;
        int[] cache = new int[n+ 1];
        cache[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int currDay = days[i];
            int nextIndexIf7DaysChosen = i + 1;
            int nextIndexIf30DaysChosen = i + 1;

            while (nextIndexIf7DaysChosen < days.length && days[nextIndexIf7DaysChosen] < currDay + 7) {
                nextIndexIf7DaysChosen++;
            }

            while (nextIndexIf30DaysChosen < days.length && days[nextIndexIf30DaysChosen] < currDay + 30) {
                nextIndexIf30DaysChosen++;
            }

            int oneDayChosen = costs[0] + cache[i + 1];
            int sevenDayChosen = costs[1] + cache[nextIndexIf7DaysChosen];
            int thirtyDayChosen = costs[2] + cache[nextIndexIf30DaysChosen];

            cache[i] = Math.min(Math.min(oneDayChosen, sevenDayChosen), thirtyDayChosen);
        }

        return cache[0] ;
        // Arrays.fill(cache , -1) ;
        // return helper(0) ;
    }

    // public int helper(int i) {
    //     if (i == d.length)
    //         return 0;

    //     if (cache[i] != -1)
    //         return cache[i];

    //     int currDay = d[i];
    //     int nextIndexIf7DaysChosen = i + 1;
    //     int nextIndexIf30DaysChosen = i + 1;

    //     while (nextIndexIf7DaysChosen < d.length && d[nextIndexIf7DaysChosen] < currDay + 7) {
    //         nextIndexIf7DaysChosen++;
    //     }

    //     while (nextIndexIf30DaysChosen < d.length && d[nextIndexIf30DaysChosen] < currDay + 30) {
    //         nextIndexIf30DaysChosen++;
    //     }

    //     int oneDayChosen = c[0] + helper(i + 1);
    //     int sevenDayChosen = c[1] + helper(nextIndexIf7DaysChosen);
    //     int thirtyDayChosen = c[2] + helper(nextIndexIf30DaysChosen);

    //     return cache[i] = Math.min(Math.min(oneDayChosen, sevenDayChosen), thirtyDayChosen);
    // }
}