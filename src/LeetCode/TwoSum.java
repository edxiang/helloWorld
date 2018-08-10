package LeetCode;

/**
 * Created by Kevin.Z on 2018/6/7.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int target = 18;
        int[] t = new TwoSum().twoSum(a,target);
        System.out.println(t[0] + "_" + t[1]);
    }

    public int[] twoSum(int[] nums, int target){
        int[] solution = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(target == nums[i] + nums[j]){
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }
        return null;
    }
}
