class MyCalendar {
    TreeMap<Integer,Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) { // 23 , 47
        Integer prevStart = calendar.floorKey(startTime); // ....22 / 23
        if(prevStart != null && calendar.get(prevStart) > startTime) return false; // 23, 24

        Integer nextStart = calendar.ceilingKey(startTime); // 23, 25, 46, 47, 48
        if(nextStart != null && nextStart < endTime) return false;

        calendar.put(startTime, endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */