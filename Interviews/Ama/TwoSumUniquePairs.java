import java.util.*;
public class TwoSumUniquePairs{
  /**
    newGrad:
    Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.

    link: https://leetcode.com/discuss/interview-question/372434
  **/

  public static int getUniquePairs1(int[] nums, int target){
    Arrays.sort(nums);  //nlogn

    int left = 0;
    int right = nums.length - 1;

    int count = 0;
    while(left < right){
      int sum = nums[left] + nums[right];
      if(sum < target){
        left ++;
      }else if(sum > target){
        right --;
      }else{
        count ++;
        left ++;
        right --;
        while(left < right && nums[left] == nums[left-1]){
          left++;
        }
        while(left < right && nums[right] == nums[right + 1]){
          right--;
        }
      }
    }

    return count;
  }

  //O(n) function
  public static int getUniquePairs2(int[] nums, int target){
    Map<Integer, Boolean> map = new HashMap<>();
    int count = 0;
    for(int num: nums){
      if(map.containsKey(target - num)){
        if(!map.get(target - num)){
          count++;
          map.put(target - num, true);
        }
        map.put(num,false);
      }else{
        map.put(num,false);
      } }
    return count;
  }



  public static void main(String[] args) {
    int[] nums1 = {1,1,2,45,46,46};
    int target1 = 47;

    int[] nums2 = {1,1};
    int target2 = 2;

    System.out.println(getUniquePairs1(nums1, target1));
    System.out.println(getUniquePairs1(nums2, target2));

    System.out.println(getUniquePairs2(nums1, target1));
    System.out.println(getUniquePairs2(nums2, target2));

  }
}
