package LeetCode;

/**
 * Created by Kevin.Z on 2018/6/7.
 */
public class LongestMountain {
    public static void main(String[] args) {
        int[] a = {2,1,4,7,3,2,5};
//        int[] a = {1, 2};
//        int[] a = {0,5,5};
//        int[] a = {0,1,2,3,4,5,4,3,2,1,0};
        System.out.println(new LongestMountain().longest(a));
    }

    private int longest(int[] A) {
        int length = 0;
        int tempLength;
        for (int i = 0; i < A.length - 1; i++) {
            tempLength = 0;
            for (int j = i; j < A.length; j++) {
                if (j + 1 == A.length) {
                    tempLength = 0;
                    break;
                }
                if (A[j + 1] > A[j])
                    tempLength++;
                else {
                    if (tempLength == 0)
                        break;
                    int tempTempLength = tempLength;
                    for (int k = j; k < A.length - 1; k++) {
                        if (A[k] > A[k + 1]) {
                            tempLength++;
                        } else {
                            break;
                        }
                    }
                    if (tempLength == tempTempLength)
                        tempLength = 0;
                    break;
                }
            }
            if (tempLength != 0)
                tempLength++;
            if (length < tempLength)
                length = tempLength;
        }
        return length;
    }

    private int t(int[] A){
        int mountain = 0;
        int start = 0;
        int curr = 0;
        boolean started = false;
        boolean peak = false;
        while(curr<A.length-1){
            //ascending
            if(A[curr] < A[curr+1] && !started){
                start = curr;
                started = true;
            }
            //end of one mountain
            else if(A[curr] < A[curr+1] && peak){
                mountain = Math.max(mountain,curr-start+1);
                peak = false;
                start = curr;
            }
            //descending
            else if(A[curr] > A[curr+1] && started){
                peak = true;
            }
            //plateau at the top
            else if(A[curr] == A[curr+1] && !peak){
                start = curr+1;
                started = false;
            }
            //plateau after peak was found
            else if(A[curr] == A[curr+1] && peak){
                mountain = Math.max(mountain,curr-start+1);
                peak = false;
                start = curr;
                started = false;
            }
            curr += 1;
        }
        return peak?Math.max(mountain,curr-start+1):mountain;
    }
}
