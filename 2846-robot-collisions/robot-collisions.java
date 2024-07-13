class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][3];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            robots[i] = new int[] { positions[i], healths[i], directions.charAt(i) == 'R' ? 0 : 1 };
            map.put(positions[i], i);
        }

        Arrays.sort(robots, (int[] x, int[] y) -> Integer.compare(x[0], y[0]));
        // for(int[] rob : robots ){
        // System.out.println(rob[0] + " : " + rob[1] + " : "+ rob[2] ) ;
        // }

        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int[] robot = robots[i];
            int pos = robot[0];
            int currHealth = robot[1];
            int direction = robot[2];
            if (st.isEmpty() || direction == 0) {
                st.push(robot);
            } else {
                if (st.peek()[2] == '1') {
                    st.push(robot);
                } else {
                    boolean flag = true;
                    while (!st.isEmpty() && st.peek()[2] == 0) {
                        int[] top = st.peek();
                        int topHealth = top[1];
                        if (topHealth == currHealth) {
                            st.pop();
                            flag = false;
                            break;
                        } else if (topHealth > currHealth) {
                            top[1] = topHealth - 1;
                            flag = false;
                            break;
                        } else {
                            st.pop();
                            currHealth--;
                        }
                    }
                    if (flag) {
                        robot[1] = currHealth;
                        st.push(robot);
                    }
                }
            }
            System.out.println(st.size());

        }

        List<int[]> list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        Collections.sort(list, (int[] x, int[] y) -> Integer.compare(map.get(x[0]), map.get(y[0])));
        List<Integer> result = new ArrayList<>();
        for (int[] temp : list) {
            result.add(temp[1]);
        }
        return result;

    }/////////
}