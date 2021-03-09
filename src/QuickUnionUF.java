public class QuickUnionUF {


    private int id[], sz[];

    public QuickUnionUF(int N)
    {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i<id.length; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }

    }
    public int root(int i)
    {
        while (id[i] != i)
        {
            id[i] = id[id[i]]; // set current node's parent to its grandparent
            i = id[i];
        } // approach root
        return i;
    }

    public boolean connected(int p, int q) {return root(p) == root(q);}
    // same root indicates objects' connectivity

    public void union(int p, int q)
    {
        int proot = root(p);
        int qroot = root(q);
        if (p == q) return;
        if (sz[proot] > sz[qroot]) { id[qroot] = proot; sz[proot]+=sz[qroot]; }
        else { id[proot] = qroot; sz[qroot] += sz[proot]; }
        // link root of smaller tree to root of larger tree
        // update sz array
    }
}
