class Solution {
    public String countOfAtoms(String formula) {
        //// get positions of the bracket value e.g - ()2
        char[] arr = formula.toCharArray();
        int n = arr.length;
        int[] marker = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n;) {
            if (arr[i] == '(') {
                st.push(i);
                i++;
            } else if (arr[i] == ')') {
                int open = st.pop();
                int curr = i;
                i++;
                if (i == n || !(arr[i] >= '0' && arr[i] <= '9')) {
                    marker[open] = 1;
                    marker[curr] = 1;
                } else {
                    StringBuilder str = new StringBuilder();
                    while (i < n && arr[i] >= '0' && arr[i] <= '9') {
                        str.append(arr[i]);
                        i++;
                    }
                    int num = Integer.parseInt(str.toString());
                    marker[open] = num;
                    marker[curr] = num;
                }
            } else {
                i++;
            }
        }
        // for(int abc : marker){
        //     System.out.println(abc) ;
        // }

        //// actual code to traverse and count
        int outerValue = 1;
        StringBuilder str = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n;) {
            char ch = arr[i];
            if (ch >= 'A' && ch <= 'Z') {
                if (str.length() > 0) {
                    String temp = str.toString();
                    map.put(temp, map.getOrDefault(temp, 0) + outerValue);
                }
                str = new StringBuilder();
                str.append(ch);
                i++;
            } else if (ch >= 'a' && ch <= 'z') {
                str.append(ch);
                i++;
            } else if (ch >= '0' && ch <= '9') {
                StringBuilder numString = new StringBuilder();
                while (i < n && arr[i] >= '0' && arr[i] <= '9') {
                    numString.append(arr[i]);
                    i++;
                }
                int num = Integer.parseInt(numString.toString());
                if (str.length() > 0) {
                    String temp = str.toString();
                    map.put(temp, map.getOrDefault(temp, 0) + num * outerValue);
                }
                str = new StringBuilder();
            } else if (ch == '(') {
                if (str.length() > 0) {
                    String temp = str.toString();
                    map.put(temp, map.getOrDefault(temp, 0) + outerValue);
                }
                str = new StringBuilder();
                outerValue *= marker[i];
                i++;
            } else {
                if (str.length() > 0) {
                    String temp = str.toString();
                    map.put(temp, map.getOrDefault(temp, 0) + outerValue);
                }
                str = new StringBuilder();
                outerValue /= marker[i];
                i++;
            }
        }
        if (str.length() > 0) {
            String temp = str.toString();
            map.put(temp, map.getOrDefault(temp, 0) + outerValue);
        }

        /// result creation
        String[] resultArr = new String[map.size()];
        int i = 0;
        for (String atom : map.keySet()) {
            String atomValue = map.get(atom) == 1 ? "" : map.get(atom)+ "" ;
            resultArr[i] = atom +atomValue;
            i++;
        }
        Arrays.sort(resultArr);
        StringBuilder result = new StringBuilder();
        for (String stn : resultArr) {
            result.append(stn);
        }

        return result.toString();
    }////

}