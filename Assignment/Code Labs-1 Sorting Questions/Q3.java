/* Q3
  * Given an array of integers, return index of the two numbers such that they add up to a specific target.
  * You may assume that each input would have exactly one solution, and you may not use the same element twice.

  * Example:
  * Given nums = [2, 7, 11, 15], target = 9,
  * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
  */

import java.util.*;
public class Q3{
  public static void main(String[] args) {
    Q3 obj = new Q3();
    int[] test1 = {2, 7, 11, 15};

    int[] result1 = obj.twoSum(test1, 9);
    System.out.println(Arrays.toString(result1));
  }

  public int[] twoSum(int[] nums, int target) {
    // pointer to the left / right bound
    int i = 0;
    int j = nums.length - 1;
    while(i < j){
      if(nums[i] + nums[j] == target){
        return new int[]{i, j};
      }else if(nums[i] + nums[j] < target){
        i++;
      }else{
        j--;
      }
    }
    return new int[2];

  }
}
