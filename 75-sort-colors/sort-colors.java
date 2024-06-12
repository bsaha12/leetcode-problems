class Solution {
    public void sortColors(int[] nums) {
        int count_1 = 0;
        int count_2 = 0;
        int count_0 = 0;
        for (int num : nums) {
            if (num == 0) {
                count_0++;
            } else if (num == 1) {
                count_1++;
            } else {
                count_2++;
            }
        }
        int i = 0;
        while (count_0-- > 0) {
            nums[i] = 0;
            i++;
        }
        while (count_1-- > 0) {
            nums[i] = 1;
            i++;
        }
        while (count_2-- > 0) {
            nums[i] = 2;
            i++;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}