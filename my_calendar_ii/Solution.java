package my_calendar_ii;

import shu_zu_zhong_de_ni_xu_dui.Solution;

import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    TimeScale head;

    public MyCalendarTwo() {
        head = new TimeScale();
    }

    public boolean book(int start, int end) {

        TimeScale debug = head;
//        while (debug!=null){
//            System.out.println(debug.start+ " " + debug.end + " " + debug.cross);
//            debug = debug.next;
//        }


        TimeScale t1 = null;
        TimeScale t2 = null;
        TimeScale cur = head;

        while(cur != null) {

            if(start < cur.start){
                if(end <= cur.start){
                    // 1.
                    break;
                }else  if(end >cur.start && end <= cur.end){
                    //2.
                    t2 = cur;
                    if(cur.cross > 1){
                        return false;
                    }
                }else{
                    //6.
                    if(cur.cross > 1){
                        return false;
                    }
                }
            }else if(start >= cur.start && start < cur.end){
                //3.
                if(end <= cur.end){
                    t1 = cur;
                    t2 = cur;
                    if(cur.cross > 1){
                        return false;
                    }
                }else {
                    // 4.
                    t1 = cur;
                    if(cur.cross > 1){
                        return false;
                    }
                }
            }else {
                // 5.
                cur = cur.next;
                continue;
            }

            cur = cur.next;
        }



        if(t1 == null || t2 == null){
            return false;
        }

//        System.out.println(t1.start+ " " + t1.end + " " + t1.cross);
//        System.out.println(t2.start+ " " + t2.end + " " + t2.cross);

        if(t1 == t2){
            int oldEnd = t1.end;
            int oldCross = t1.cross;
            TimeScale oldNext = t1.next;

            TimeScale timeScale = new TimeScale(start,end,oldCross + 1);

            t1.end = start;
            t1.next = timeScale;

            TimeScale timeScale2 = new TimeScale(end,oldEnd,oldCross);
            t1.next.next = timeScale2;
            t1.next.next.next = oldNext;

        }else{

            if(t1.next != t2){
                for (TimeScale t = t1.next; t != t2; t = t.next) {
                    t.cross = t.cross + 1;
                }
            }

            int oldEnd = t1.end;
            int oldCross = t1.cross;

            int oldEnd2 = t2.end;
            int oldCross2 = t2.cross;

            if(start == t1.start){
                t1.cross += 1;
            }else {
                TimeScale oldNext1 = t1.next;

                t1.end = start;
                TimeScale timeScale = new TimeScale(start,oldEnd,oldCross + 1);
                t1.next = timeScale;
                t1.next.next = oldNext1;
            }

            if(t2.end == end){
                t2.cross += 1;
            }else {
                TimeScale oldNext2 = t2.next;
                t2.end = end;
                t2.cross = oldCross2 + 1;
                TimeScale timeScale1 = new TimeScale(end,oldEnd2,oldCross2);
                t2.next = timeScale1;
                t2.next.next = oldNext2;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo s = new MyCalendarTwo();
        System.out.println(s.book(26,35));
        System.out.println(s.book(24,32));
        System.out.println(s.book(25,32));
        System.out.println(s.book(18,16));
        System.out.println(s.book(40,45));
        System.out.println(s.book(19,26));

        System.out.println(s.book(48,50));
        System.out.println(s.book(1,6));
        System.out.println(s.book(46,50));
        System.out.println(s.book(11,18));
//["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book"]
//[[],[26,35],[26,32],[25,32],[18,26],[40,45],[19,26],[48,50],[1,6],[46,50],[11,18]]
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

class TimeScale{
    public int start = Integer.MIN_VALUE;
    public int end = Integer.MAX_VALUE;
    public int cross = 0;

    TimeScale next;

    TimeScale(int start,int end,int cross){
        this.start = start;
        this.end = end;
        this.cross = cross;
    }

    TimeScale(){

    }
}