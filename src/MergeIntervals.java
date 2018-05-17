import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public List<Interval> mergeInterval(List<Interval> intervals) {
        int time = 0;
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval it : intervals) {
            if (it.start > end) {
               // res.add(new Interval(start, end));
                time += end - start;
                start = it.start;
                end = it.end;
            } else {
                start = Math.min(start, it.start);
                end = Math.max(end, it.end);
            }

        }
        time += end - start;
        //res.add(new Interval(start,end));

        for(Interval i : res) {
            System.out.println(i.start + " :" + i.end);
        }
        System.out.println(time);
        return res;
    }


    public static void main(String[] args) {
        Interval it1 = new Interval(2,6);
        Interval it2 = new Interval(3,7);
        Interval it3 = new Interval(8,9);
        Interval it4 = new Interval(1,5);
        List<Interval> res = new ArrayList<>();
        res.add(it1);
        res.add(it2);
        res.add(it3);
        res.add(it4);
        MergeIntervals mg = new MergeIntervals();
        mg.mergeInterval(res);
    }
}
