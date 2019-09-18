/* Q4
 	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
	 * s = "leetcode" return 0.
	 * s = "loveleetcode" return 2.
     */
import java.util.*;
public class Q4{
  public static void main(String[] args) {
    Q4 obj = new Q4();
    String s1 = "leetcode";
    String s2 = "loveleetcode";
    int result1 = obj.firstUniqChar(s1);
    int result2 = obj.firstUniqChar(s2);
    System.out.println(result1);
    System.out.println(result2);
  }
  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for(char c: s.toCharArray()){
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for(int i = 0; i < s.length(); i++){
      if(map.get(s.charAt(i)) == 1){
        return i;
      }
    }
    return -1;
  }
}
