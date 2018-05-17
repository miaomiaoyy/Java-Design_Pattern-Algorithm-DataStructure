package JavaOffer_Solutions;

import com.sun.tools.internal.xjc.reader.gbind.Graph;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

public class Bit_count {
    public static void main(String[] args) {
        int i = 3;
        int j = 2;
//        System.out.println(i & 1); //两个都是1 才是1
//        System.out.println(i >> 1);//不要最后一位
//        System.out.println(j & 1);
//        System.out.println(j >> 1);
        for(int t : countBits(4)) {
            System.out.println(t);
        }
    }
    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }


}
