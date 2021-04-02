package MathematicalModel;

import java.util.Arrays;

public class ImprovedThreeSum {

    private int BinarySearch (int[] ary, int key) {
        int left=0, right = ary.length-1;
        while (left<=right)
        {
            int mid = (left+right)/2;
            if (ary[mid] > key) right = mid-1;
            else if (ary[mid]<key) left = mid+1;
            else return mid;
        }
        return -1;
    }
    public void FindAnswer(int[] ary) {
        Arrays.sort(ary, 0, ary.length-1); // sort the array
        for (int i = 0; i<ary.length-1; i++)
            for (int j = i+1; j<ary.length; j++)
            {
                int result = BinarySearch(ary, -(ary[i]+ary[j]));
                if (result != -1) System.out.println(String.format("%d %d %d",ary[i],ary[j], ary[result])); // possible answer
            }
    }

}
