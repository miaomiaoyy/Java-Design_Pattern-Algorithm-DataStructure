import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MeetingRoom {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    //return the time with most meeting
    //[0,20],[3,10],[4,8][15,20]  meeting room number 3
    public static int findMostMeeting(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int end = intervals[0].end;
        pq.offer(end);
        int overlapstart = 0, overlapend = 0, time = 1,count = 0;
        Interval res = new Interval(intervals[0].start, intervals[0].end);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < pq.peek()) {
                pq.offer(intervals[i].end);
                time++;
                overlapstart = intervals[i].start;
                overlapend = Math.min(end, intervals[i].end);
            } else {
                if(time > count) {
                    count = time;
                    res = new Interval(overlapstart, overlapend);
                }
                time = 1;
                end = Math.max(pq.poll(), intervals[i].end);
                pq.offer(end);
            }
        }
        System.out.println(res.start + ":" + res.end);
        return pq.size();
    }

    public static void main(String[] args) {
       Interval it1 = new Interval(5,10);
       Interval it2 = new Interval(3,10);
       Interval it3 = new Interval(4,10);
       Interval it4 = new Interval(10,20);
       Interval[] intervals = {it1,it2,it3,it4};
       System.out.println(findMostMeeting(intervals));
    }
}
