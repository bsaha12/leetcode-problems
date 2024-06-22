class Solution {
    List<List<Integer>> list;
    int[] arr;
    List<Integer> path;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list = new ArrayList<>();
        path = new ArrayList<>();
        arr = candidates;
        Arrays.sort(arr);
        helper(0, target);

        return list;
    }//////

    void helper(int start, int target) {
        // base conditions
        if (target < 0)
            return;
        if (target == 0) {
            list.add(new ArrayList(path));
            return;
        }

        // actual body
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1])
                continue;

            path.add(arr[i]);
            helper(i + 1, target - arr[i]);
            path.remove(path.size() - 1);
        }

    }////
}