import edu.princeton.cs.algs4.Stopwatch;

import java.util.Scanner;

public class testforgrid extends GridImplement {


    public testforgrid(int N) {
        super(N);
    } /* ?? */

    public static void main(String[] args)
    {
        int trial = 0, N, repeat;
        double tlr = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        repeat = sc.nextInt();
        Stopwatch alltime = new Stopwatch();
        for (int cnt = 1 ; cnt<=repeat; cnt++) // test 10 times and get average
        {
            Stopwatch sw = new Stopwatch();
            GridImplement grid = new GridImplement(N);
            while (true)
            {
                boolean[] status = grid.openRoom();
                if (status[0]) trial++;
                else continue; // an already open tile
                /*for (int i = 0; i<N; i++) {
                    for (int j = 0; j < N; j++)
                    {
                        System.out.print((grid.Grid[i][j]? "\u2B1C" : "\u2B1B")+ " ");
                    }
                    System.out.println();
                }*/
                //System.out.println();
                if (status[1]) break;
            }
            System.out.println("Trial " + cnt + " for grid of " + N + " X " + N + ": " + trial + "/" + N*N);
            System.out.println("Elapsed Time: " + sw.elapsedTime() + " s\n");
            tlr+=(double) trial/(N*N) * 100;
            trial = 0;
        }

        System.out.println(String.format("%.2f", tlr/(double)repeat));
        System.out.println(alltime.elapsedTime() + " s");


        //System.out.println("percolated after " + trial + " trial(s)");
        //System.out.println("vacc percent: " + String.format("%.4f", (double) trial/(N*N) * 100));

    }

}
