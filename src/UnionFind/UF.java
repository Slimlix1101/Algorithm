/* First version of union-find, which is not improved yet */
package UnionFind;
public class UF {

    private int[] ary;
    public UF(int N)
    {
        ary = new int[N];
        for (int i = 0; i < ary.length; i++)
            ary[i] = i;
    }

    public void union (int p, int q)
    {
        int pid = ary[p];
        int qid = ary[q];
        for (int i : ary)
            if (i == qid) i = pid;
    }

    public boolean connected(int p, int q)
    {
            return ary[p] == ary[q];
    }

}


