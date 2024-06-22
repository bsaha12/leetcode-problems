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

    void helper(int i, int target) {
        // base case
        if (target == 0) {
            List<Integer> temp = new ArrayList<>();
            for (Integer n : path) {
                temp.add(n);
            }
            list.add(temp);
            return ;
        }
        if(target < 0){
            return ;
        }

        // actual function logic
        int len = arr.length;

        // skip duplicates
        while (i != 0 && i < len && arr[i] == arr[i - 1]) {
            i++;
        }

        while (i < len) {
            int currTarget = target ;
            path.add(arr[i]);
            currTarget -= arr[i] ;
            helper(i + 1, currTarget );
            i++;
            int dups = 0;
            while (i < len && arr[i] == arr[i - 1]) {
                path.add(arr[i]);
                currTarget -= arr[i] ;
                helper(i + 1, currTarget);
                dups++;
                i++;
            }
            while (dups-- > 0) {
                path.remove(path.size() - 1);
            }
            path.remove(path.size() - 1);
        }

    }////
}