class Solution {
    public int trap(int[] height) {
        int n = height.length ;
        int[] leftGreater = new int[n] ;// storing the index of greatest element to it's left
        int[] rightGreater = new int[n] ;// storing the index of greatest element to it's right

        // Stack<Integer> st = new Stack<>() ;
        int currMax = 0 ;
        // populating next greater left
        for(int i = 0 ; i < n ; i++){
            // while(!st.isEmpty() && height[st.peek()] <= height[i]){ // 3 = 3 , 3 < 4 ; 4 > 3
            //     st.pop() ;
            // }

            // if(st.isEmpty()){
            //     leftGreater[i] = -1 ;
            // }else{
            //     leftGreater[i] = st.peek() ;
            // }

            // st.push(i) ;
            leftGreater[i] = currMax ;
            currMax = Math.max(height[i] , currMax) ;
        }

        // System.out.println(Arrays.toString(leftGreater));

        currMax = 0 ;
        // st = new Stack<>() ;
        // populating next greater right
        for(int i = n - 1 ; i >= 0 ; i--){
            // while(!st.isEmpty() && height[st.peek()] <= height[i]){ // 3 = 3 , 3 < 4 ; 4 > 3
            //     st.pop() ;
            // }
            
            // if(st.isEmpty()){
            //     rightGreater[i] = -1 ;
            // }else{
            //     rightGreater[i] = st.peek() ;
            // }

            // st.push(i) ;

            rightGreater[i] = currMax ;
            currMax = Math.max(height[i] , currMax) ;
        }

        // find trapped water content
        int trappedWater = 0 ;
        for(int i = 0 ; i < n ; i++){
            int level = Math.min(rightGreater[i] , leftGreater[i] ) ;
            if(level > height[i]){
                trappedWater += (level - height[i]) ;
            }
        }
        return trappedWater ;
    }
}