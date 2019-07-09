import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MaxHeap1 {

    private static void disp(int n, int[] maxHeap){
        for (int i=0; i<n; i++){
            System.out.print(maxHeap[i] + " ");
        }
        System.out.println(" ");
    }

    @Contract(pure = true)
    private static boolean checkHeap(int n, int[] maxHeap){
        for (int i=n-1; i>0; i--){
            int k = (i+1)/2 - 1;
            if (maxHeap[i] > maxHeap[k])
                return false;
        }
        return true;
    }

    private static void heapify(int n, int[] maxHeap, int con){
        int k, t;
        for (int i = n-1; i>0; i--){

            while (true) {
                if (i==0)   break;
                k = (i+1)/2 - 1;
                if (maxHeap[i] > maxHeap[k]){
                    t = maxHeap[i];
                    maxHeap[i] = maxHeap[k];
                    maxHeap[k] = t;
                    i = k;
                }
                else break;
            }

            if (con == 1)   break;
        }
    }

    private static void del(int n, @NotNull int[] maxHeap){
        int t = maxHeap[0];
        maxHeap[0] = maxHeap[n-1];
        maxHeap[n-1] = t;
    }

    public static void main(String[] args) {

        int n, val, pval, p=0, t, k;
        Scanner s = new Scanner(System.in);

        System.out.print("Number of elements: ");
        n = s.nextInt();

        int[] maxHeap = new int[n];

        for(int i=0; i<n; i++){
            System.out.print("Enter value: ");
            maxHeap[i] = s.nextInt();

            heapify(i+1, maxHeap, 1);
        }

/*
        while (checkHeap(n, maxHeap) == false) {
            heapify(n, maxHeap, 0);
        }
*/
        disp(n, maxHeap);

        /*DELETION*/

        System.out.println("Deleting root note");

        del(n, maxHeap);

        n--;
/*
        while (checkHeap(n, maxHeap) == false) {
            heapify(n, maxHeap, 0);
        }
 */
        heapify(n, maxHeap, 0);

        disp(n, maxHeap);
    }
}
