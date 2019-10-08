public class SubtreeOfAnotherTree{
/*
  newGrad:
  link: https://leetcode.com/problems/subtree-of-another-tree/
*/

  public boolean isSubtree(TreeNode s, TreeNode t) {
      if(s == null){
          return false;
      }

      return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public boolean isSame(TreeNode one, TreeNode two){
      if(one == null && two == null){
          return true;
      }
      if(one == null || two == null){
          return false;
      }
      if(one.val != two.val){
          return false;
      }

      boolean left = isSame(one.left, two.left);
      boolean right = isSame(one.right, two.right);

      return left && right;
  }
}
