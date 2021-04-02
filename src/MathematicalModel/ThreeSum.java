package MathematicalModel;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum
{
    public static void FindAnswer(int[] a)
    {
        int N = a.length, count=0;
        for (int i = 0; i<N; i++)
            for (int j = i+1; j<N; j++)
                for (int k = j+1; k<N; k++)
                    if (a[i] + a[j] + a[k] == 0) count++;
        System.out.println(count);
    }

    public static void main(String[] args)
    {
        File file = new File("C:\\Users\\User\\Desktop\\Nums\\10000.txt");
        try {
            Scanner sc = new Scanner(file);
            int N = sc.nextInt();
            int[] a = new int[N];
            for (int i=0; i<N; i++)
                a[i] = sc.nextInt();
            Stopwatch sw = new Stopwatch();
            FindAnswer(a);
            System.out.println(String.format(("%.3f"), sw.elapsedTime()));

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }



    }
}
