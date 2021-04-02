package MathematicalModel;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum
{
    public static void FindAnswer(int[] a)
    {
        int N = a.length;
        for (int i = 0; i<N; i++)
            for (int j = i+1; j<N; j++)
                for (int k = j+1; k<N; k++)
                    if (a[i] + a[j] + a[k] == 0) System.out.println(String.format("%d %d %d",a[i],a[j],a[k])); // ignore overflow
    }

    public static void main(String[] args)
    {
        int N;
        N = StdIn.readInt();
        int[] a = new int[N];
        for (int i=0; i<N; i++)
            a[i] = StdIn.readInt();

        Stopwatch sw = new Stopwatch();
        FindAnswer(a);
        System.out.println(sw.elapsedTime());
    }
}
