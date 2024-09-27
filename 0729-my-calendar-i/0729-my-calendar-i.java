class Event
{
    int start;
    int end;
    public Event(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {
    List<Event> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
        
    }
    
    public boolean book(int start, int end) {
        for(Event e: bookings){
            if(isOverlap(e, start, end)){
                return false;
            }
        }
        bookings.add(new Event(start,end));
        return true;
        
    }

    public boolean isOverlap(Event e, int start, int end){
        return Math.max(e.start,start)<Math.min(e.end,end);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */