package UnionFind;
public class SuccessorWithDelete {

    private int size;

    private int[] id;
    private boolean[] status;

    public SuccessorWithDelete(int n)
    {
        size = n;
        id = new int[n];
        status = new boolean[n];
        for (int i = 0; i<n; i++)
        {
            id[i] = i;
            status[i] = true; // true <=> elements not removed
        }
    }

    public int root(int i)
    {
        while (id[i] != i)
        {
            id[i] = id[id[i]]; // path compression
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q)
    {
        int prt = root(p);
        int qrt = root(q);

        if (prt == qrt) return;
        else if (prt > qrt) id[qrt] = prt;
        else id[qrt] = prt; // root with bigger value become new root after union
    }

    public void remove(int p)
    {
        if (p < 0 || p >= size) return; // out of range
        status[p] = false;
        if (!status[p+1]) union(p,p+1);
        if (!status[p-1]) union(p, p-1);
        // if removed elements are next to each other, connect them
    }

    public int FindSuccessor(int p)
    {
        if (p<0 || p>= size) return -1; // out of range
        int prt = root(p);

        if (!status[p]) // p is removed
        {
            if (prt == size-1) return -1; // every integer bigger than p is removed
            else return prt+1;

        } else return p; // p is not removed
    }
}
