class StockSpanner {

    List<Integer> list ;
    Stack<Integer> st ;
    int i ;

    public StockSpanner() {
        list = new ArrayList<>() ;
        st = new Stack<>() ;
        i = -1 ;
    }
    
    public int next(int price) {
        // System.out.println("Price : "+ price ) ;
        i++ ;
        int ans = 1 ;
        while(!st.isEmpty() && list.get(st.peek()) <= price ){
            st.pop() ;
        }

        if(st.isEmpty()) ans = i + 1;
        else ans = i - st.peek() ;

        st.push(i) ;
        list.add(price) ;

        // System.out.println("Ans : "+ ans ) ;

        return ans ;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */