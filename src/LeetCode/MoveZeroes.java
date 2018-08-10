package LeetCode;

/**
 * Created by Kevin.Z on 2018/6/19.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 0};
        new MoveZeroes().moveZeroes(nums);
    }

    private void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
    }

    private void betterSolution(int[] nums){
        int writeIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[writeIdx++] = nums[i];
            }
        }
        for (int i = writeIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
