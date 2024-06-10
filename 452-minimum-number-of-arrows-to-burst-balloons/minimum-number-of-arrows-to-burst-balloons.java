class Solution {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, new Comparator<int[]>() {
        //     @Override
        //     public int compare(final int[] entry1,
        //             final int[] entry2) {

        //         if (entry1[1] > entry2[1])
        //             return 1;
        //         else if (entry1[1] < entry2[1])
        //             return -1;
        //         else
        //             return Integer.compare(entry1[0], entry2[0]);
        //     }
        // });
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int i = 0;
        while (i < points.length) {
            int start = points[i][0];
            int end = points[i][1];
            count++;
            i++;
            while (i < points.length && points[i][0] <= end) {
                i++;
            }
        }
        return count;
    }
}