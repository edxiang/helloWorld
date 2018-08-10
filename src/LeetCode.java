import org.junit.Test;

/**
 * Created by Kevin.Z on 2018/5/24.
 */
public class LeetCode {

    public static void main(String[] args) {
//        new LeetCode().findPivotIndex();
        String x = "123+456";
        System.out.println(x.substring(0, x.indexOf("+")));
        System.out.println(x.substring(x.indexOf("+") + 1, x.length()));
    }

    public void findPivotIndex() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int index = -1;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            leftSum += nums[i];
            rightSum += nums[j];
            if (leftSum == rightSum) {
                index = i + 1;
                break;
            }
        }
        System.out.println(index);
    }
}
