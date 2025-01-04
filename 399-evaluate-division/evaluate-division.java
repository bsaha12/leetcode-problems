class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //1. create adjList , also get the set of unique strings
        Set<String> variableSet = new HashSet<>() ;
        for(List<String> equation : equations){
            variableSet.add(equation.get(0)) ;
            variableSet.add(equation.get(1)) ;
        }
        List<String> variables = new ArrayList<>(variableSet) ;
        Map<String,Integer> map = new HashMap<>() ;
        int i = 0 ;
        for(String variable : variables){
            map.put(variable , i) ;
            i++ ;
        }
        int variableCount = variables.size() ;
        double[][] adjMatrix = new double[variableCount][variableCount] ;
        i = 0 ;
        for(List<String> equation : equations){
            int variable1 = map.get(equation.get(0))  ;
            int variable2 = map.get(equation.get(1)) ;
            double val = values[i] ;
            double reverseVal = 1/val ;
            adjMatrix[variable1][variable2] = val ;
            adjMatrix[variable2][variable1] = reverseVal ;
            i++ ;
        }

        //get the queries done
        int queryCount = queries.size() ;
        double[] result = new double[queryCount] ;
        i = 0 ;
        for(List<String> query :queries ){
            double queryVal = -1 ;
            Integer var1 = map.get(query.get(0));
            Integer var2 = map.get(query.get(1));
            if(var1 != null && var2 != null){
                double pathVal = BFS(adjMatrix , var1 , var2) ;
                queryVal = pathVal ;
            }
            result[i] = queryVal ;
            i++ ;
        }

        return result ;

    }//
    public double BFS(double[][] adjMatrix , int var1 , int var2){
        Queue<Integer> que = new LinkedList<>() ;
        Set<Integer> visited = new HashSet<>() ;
        que.add(var1) ;
        visited.add(var1) ;
        double[] pathVals = new double[adjMatrix.length] ; 
        pathVals[var1] = 1 ;
        while(!que.isEmpty()){
            Integer curr = que.remove() ;
            double currVal = pathVals[curr] ;
            if(curr == var2) return currVal ;
            int i = 0 ;
            for(double weight : adjMatrix[curr]){
                if(weight > 0 && !visited.contains(i)){
                    visited.add(i) ;
                    pathVals[i] = currVal * weight ;
                    que.add(i) ;
                }
                i++ ;
            }
        }
        return -1 ;
    }////
}