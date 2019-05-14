package slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
           // int d = q.peek();
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            //int l = q.peekLast();
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                int p = q.peek();
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String args[]){
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int ans [] = swm.maxSlidingWindow(arr,k);

        for(int a: ans){
            System.out.println(a);
        }

    }
}
