package MathematicalModel;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestForThreeSum extends ImprovedThreeSum {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\User\\Desktop\\Nums\\10000.txt");
        try {
            ImprovedThreeSum improvedThreeSum = new ImprovedThreeSum();
            Scanner sc = new Scanner(file);
            int N = sc.nextInt();
            int[] a = new int[N];
            for (int i=0; i<N; i++)
                a[i] = sc.nextInt();
            Stopwatch sw = new Stopwatch();
            improvedThreeSum.FindAnswer(a);
            System.out.println(String.format(("%.3f"), sw.elapsedTime()));

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


    }
}
