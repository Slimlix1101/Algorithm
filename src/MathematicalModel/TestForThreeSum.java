package MathematicalModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class TestForThreeSum extends ImprovedThreeSum {

    public static void main(String[] args) {

        ImprovedThreeSum improvedThreeSum = new ImprovedThreeSum();
        int N;
        N = StdIn.readInt();
        int[] a = new int[N];
        for (int i=0; i<N; i++)
            a[i] = StdIn.readInt();

        Stopwatch sw = new Stopwatch();
        improvedThreeSum.FindAnswer(a);
        System.out.println(sw.elapsedTime());
    }
}
