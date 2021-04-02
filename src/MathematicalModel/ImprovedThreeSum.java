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

        int count=0;
        Arrays.sort(ary, 0, ary.length); // sort the array
        for (int i = 0; i<ary.length; i++)
            for (int j = i+1; j<ary.length; j++)
            {
                int result = BinarySearch(ary, -(ary[i]+ary[j]));
                if (result != -1 && ary[i] < ary[j] && ary[j] < ary[result]) count++; // possible answer, double counting avoided

            }
        System.out.println(count);
    }

}
