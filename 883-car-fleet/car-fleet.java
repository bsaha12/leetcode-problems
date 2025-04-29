class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length ;
        Driver[] drivers = new Driver[n] ;
        for(int i = 0 ; i < n ; i++){
            int inPos = position[i] ;
            int spd = speed[i] ;
            double pRT = (double) (target - inPos) / spd ;
            Driver driver = new Driver(pRT , inPos , spd) ;
            drivers[i] = driver ;
        }
        Arrays.sort(drivers , (a , b) -> {
            if(a.inPos < b.inPos) return 1 ;
            else return -1 ;
        });
        // for(int i = 0 ; i < n ; i++){
        //     Driver driver = drivers[i] ;
        //     System.out.println( "PRT : "+ driver.pRT + " , POS : " + driver.inPos + " , SPD : " + driver.speed ) ;
        // }
        int fleets = 0 ;
        double prev = 0 ;
        for(int i = 0 ; i < n ; i++){
            Driver driver = drivers[i] ;
            double prt = driver.pRT ;
            if(prt > prev){
                fleets++ ;
                prev = prt ;
            }
        }
        return fleets ;
    }
}

class Driver{
    double pRT ;
    int inPos ;
    int speed ;

    public Driver(double _pRT , int _inPos , int _speed){
        pRT = _pRT ;
        inPos = _inPos ;
        speed = _speed ;
    }
}