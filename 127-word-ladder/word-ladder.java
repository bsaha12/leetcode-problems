class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int source = -1;
        int target = -1;
        for (int i = 0; i < wordList.size(); i++) {
            String curr = wordList.get(i);
            if (curr.equals(endWord))
                target = i;
            if (curr.equals(beginWord))
                source = i;
        }

        if (target == -1)
            return 0;
        if (source == -1) {
            wordList.add(beginWord);
            source = wordList.size() - 1;
        }
        Map<Integer, List<Integer>> adjList = convertToGraph(wordList);
        return findMinDistance(source, target, adjList);
    }

    public boolean isEditable(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        char[] arr1 = str1.toCharArray() ;
        char[] arr2 = str2.toCharArray() ;

        int len = arr1.length ;
        int editCount = 0 ;
        for(int i = 0 ; i < len ; i++){
            if(arr1[i] != arr2[i]) editCount++ ;
        }
        return editCount == 1 ? true : false ;
    }

    public Map<Integer, List<Integer>> convertToGraph(List<String> wordList) {
        int size = wordList.size();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < size; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String str1 = wordList.get(i);
                String str2 = wordList.get(j);
                if (isEditable(str1, str2)) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        return adjList;
    }

    public int findMinDistance(int source, int target, Map<Integer, List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        int steps = 1;
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        while (queue.size() > 0) {
            Queue<Integer> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                tempQueue.add(queue.remove());
            }
            // System.out.println("Step : " + steps);
            while (!tempQueue.isEmpty()) {
                int node = tempQueue.remove();
                // System.out.println("Node : " + node);
                if (node == target)
                    return steps;
                // System.out.println("Neighbors : " + adjList.get(node));
                for (int next : adjList.get(node)) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }

            steps++;
        }
        return 0;
    }

}