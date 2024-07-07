class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles ;
        int empty = numBottles ;
        while(empty >= numExchange){
            int fulls = empty / numExchange ;
            result += fulls ;
            empty = empty % numExchange + fulls ;
        }
        return result ;
    }
}