class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int count = 0;
        int i = 0, j = 0;
        int n = nums.length;
        while (j < n) {
            count += nums[j] % 2 != 0 ? 1 : 0;
            if (count == k) {
                int lead = 1;
                while (i < j && nums[i] % 2 == 0) {
                    i++;
                    lead++;
                }

                int trail = 1;
                j++;
                while (j < n && nums[j] % 2 == 0) {
                    trail++;
                    j++;
                }

                result += (lead * trail);
                i++;
                count-- ;
            }
            else j++;
        }

        return result;
    }
}