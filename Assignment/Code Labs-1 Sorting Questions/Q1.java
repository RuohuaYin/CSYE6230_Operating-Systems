/* Q1
 * Given an array nums, write a function to find the first maximum value's index.
 * If there is no index that satisfies the conditions in the problem statement, we should return -1.
 * Input: [3,5,6,2,1,9] Output: 5
 * Explanation: 9 is the maximum value, and its index is 5.

 * Input: [2,4,4,1] Output: 1
 * Explanation: 4 is the maximum value, and the first 4's index is 1.
 */
public class Q1{
  public static void main(String[] args) {

    Q1 obj = new Q1();
    int[] test1 = {3, 5, 6, 2, 1, 9};
    int[] test2 = {2, 4, 4, 1};
    int result1 = obj.maxIndex(test1);
    int result2 = obj.maxIndex(test2);
    System.out.println(result1);
    System.out.println(result2);

  }

  public int maxIndex(int[] arr) {
    if(arr == null || arr.length == 0){
      return -1;
    }
    int result = -1;
    int curMax = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length; i++){
      int curNum = arr[i];
      if(curNum > curMax){
        result = i;
        curMax = curNum;
      }
    }
    return result;
  }
}
