class AuthenticationManager {

    int ttl ;
    Map<String , Integer> map = new HashMap<>() ;

    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive ;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId , currentTime + ttl) ;
        
    }
    
    public void renew(String tokenId, int currentTime) {
        Integer time = map.get(tokenId) ;
        if(time != null && currentTime < time){
            map.put(tokenId , currentTime + ttl) ;
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0 ;
        for(String token : map.keySet()){
            int expiryTime = map.get(token) ;
            if(expiryTime > currentTime){
                count++ ;
            }
        }

        return count ;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */