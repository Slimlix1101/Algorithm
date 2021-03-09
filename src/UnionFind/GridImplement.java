package UnionFind;
import java.util.Random;

public class GridImplement {

    public boolean Grid[][];
    public int connection[];

    private int sz[];
    private int dir[] = {1, -1, 0, 0};

    private int size;
    Random rd = new Random();

    public GridImplement(int N)
    {
        Grid = new boolean[N][N];
        connection = new int[N*N+2];
        sz = new int[N*N+2];

        for (int i = 0; i<N; i++)
            for (int j = 0; j<N; j++)
            {
                Grid[i][j] = false;
                connection[i*N+j] = i == 0? N*N : i == N-1? N*N+1 : i*N+j;
                sz[i*N+j] = (i == 0) ? N+1 : (i == N-1? N+1:1);
            }
        connection[N*N] = N*N; sz[N*N] = N+1;
        connection[N*N+1] = N*N+1; sz[N*N+1] = N+1;

        size = N;
        dir[2] = size;
        dir[3] = -size;
    }

    private int[] randomRoom(int N)
    {
        int roomnum[] = {0, 0};
        int x = rd.nextInt(N*N);
        roomnum[0] = x/N;
        roomnum[1] = x%N;
        return roomnum;
    }

    public boolean[] openRoom()
    {
        int pos[] = randomRoom(size);
        boolean status[] = {false, false};

        if (!Grid[pos[0]][pos[1]]) {
            status[0] = true;
            Grid[pos[0]][pos[1]] = true;
        } else return status; // already open tile

        int cntpos = pos[0]*size+pos[1], altpos;
        // System.out.println("open room at " + cntpos);
        for (int cnt = 0; cnt<=3; cnt++)
            try {
                altpos = cntpos+dir[cnt];
                if (altpos/size != cntpos/size && cnt <= 1) continue; // not on same row
                if (altpos >= size*size) continue;
                if (Grid[altpos/size][altpos%size]) {
                    // System.out.println("union of " + cntpos + " and " + altpos);
                    union(connection[cntpos], connection[altpos]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {  }

        status[1] = connected(size*size, size*size+1);

        return status;
    }

    private int root(int p) // position
    {
        while (connection[p] != p)
        {
            connection[p] = connection[connection[p]];
            p = connection[p];
        }
        return p; // which is the position
    }

    private boolean connected(int p, int q) {return root(p) == root(q);} // position

    private void union(int p, int q) // position
    {
        int prt = root(p);
        int qrt = root(q);
        if (p == q) return;
        if (sz[prt] > sz[qrt]) { connection[qrt] = prt; sz[prt] += sz[qrt]; }
        else { connection[prt] = qrt; sz[qrt] += sz[prt]; }
        // link root of smaller tree to root of larger tree
        // update sz array
    }



}
