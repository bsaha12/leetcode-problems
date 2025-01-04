class Solution {
    Map<String , String> parent ;
    Map<String , Double> weight ;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>() ;
        weight = new HashMap<>() ;
        int queryCount = queries.size() ;
        double[] result = new double[queryCount] ;
        int i = 0 ;
        for(List<String> equation : equations){
            union(equation.get(0) , equation.get(1) , values[i]) ;
            i++ ;
        }
        i= 0 ;
        for(List<String> query : queries){
            String varA = query.get(0) ;
            String varB = query.get(1) ;
            if(!parent.containsKey(varA) || !parent.containsKey(varB) || !find(varA).equals(find(varB))){
                result[i] = -1 ;
            }else{
                result[i] = weight.get(varA) / weight.get(varB) ;
            }
            i++ ;
        }
        return result ;
    }//

    public void union(String x , String y , double value){
        if(!parent.containsKey(x)){
            parent.put(x , x) ;
            weight.put(x , 1.0) ;
        }
        if(!parent.containsKey(y)){
            parent.put(y , y) ;
            weight.put(y , 1.0) ;
        }
        String rpsX = find(x) ;
        String rpsY = find(y) ;
        parent.put(rpsX , rpsY) ;
        weight.put(rpsX , value * weight.get(y)/weight.get(x)) ;////
    }//

    public String find(String x){
        if(!x.equals(parent.get(x) )){
            String originalParent = parent.get(x) ;
            String rootX = find(originalParent) ;
            parent.put(x , rootX) ;
            weight.put(x , weight.get(x) * weight.get(originalParent)) ;
        }
        return parent.get(x) ;
    }//
}