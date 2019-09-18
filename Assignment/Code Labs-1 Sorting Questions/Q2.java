/* Q2
	 * Kth Largest Element in an Array
	 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
	 * Input: [3,2,1,5,6,4] and k = 2
	 * Output: 5

	 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
	 * Output: 4
	 */
import java.util.*;
public class Q2{
  public static void main(String[] args) {
    Q2 obj = new Q2();
    int[] test1 = {3,2,1,5,6,4};
    int[] test2 = {3,2,3,1,2,4,5,5,6};

    int result1 = obj.findKthLargest(test1, 2);
    int result2 = obj.findKthLargest(test2, 4);
    System.out.println(result1);
    System.out.println(result2);
  }

  // Sort then use index
  // Time: O(nlogn)
  public int findKthLargest(int[] nums, int k) {
    //we can implement any sorting algorithm in O(nlogn) Complexity
    //java internal sorting al
      Arrays.sort(nums);
      return nums[nums.length - k];
  }

}
