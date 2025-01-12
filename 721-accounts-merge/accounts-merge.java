class Solution {
    Map<String , String> parent = new HashMap<>() ;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String , String> map = new HashMap<>() ;
        for(List<String> currAccount : accounts){
            int size = currAccount.size() ;
            String name = currAccount.get(0) ;

            String prev = currAccount.get(1) ;
            map.put(prev , name) ;
            if(!parent.containsKey(prev)){
                parent.put(prev , prev) ;
            }
            for(int i = 2 ; i < size ; i++ ){
                String curr = currAccount.get(i) ;
                map.put(curr , name) ;
                if(!parent.containsKey(curr)){
                    parent.put(curr , curr) ;
                }
                union(curr , prev) ;
            }
        }
        Map<String , List<String>> resultMap = new HashMap<>() ; 
        for(String email : map.keySet()){
            String rps = find(email) ;
            if(!resultMap.containsKey(rps)){
                resultMap.put(rps , new ArrayList<>()) ;
            }
            resultMap.get(rps).add(email) ;
        }

        List<List<String>> result = new ArrayList<>() ;
        for(String rps : resultMap.keySet()){
            List<String> emails = resultMap.get(rps) ;
            Collections.sort(emails) ;
            emails.add(0 , map.get(rps)) ;
            result.add(emails) ;
        }
        return result ;

    }//
    public void union(String mail1 , String mail2){
        String rps1 = find(mail1) ;
        String rps2 = find(mail2) ;
        if(rps1.equals(rps2)){
            return ;
        }

        parent.put(rps1 , rps2) ;
    }//
    public String find(String mail){
        if(!parent.get(mail).equals(mail)){
            parent.put(mail , find(parent.get(mail))) ;
        }
        return parent.get(mail) ;
    }//
}
