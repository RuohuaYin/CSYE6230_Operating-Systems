class ConstructBinaryTreefromPreorderandInorderTraversal{
  /**
    link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
  **/
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = convertToMap(inorder);
    // represent left and right border of
    /*
     0  1  2   3   4    index:
    [3, 9, 20, 15, 7]   preOrder arr
     l             r
    [9, 3, 15, 20, 7]   inOrder arr -> map, convenient to check
     l  m          r
    */
    return helper(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode helper(int[] pre, Map<Integer, Integer> map, int inLeft, int inRight, int preLeft, int preRight){
    if(inLeft > inRight){
        return null;
    }

    TreeNode root = new TreeNode(pre[preLeft]);
    int inMid = map.get(pre[preLeft]);
    root.left = helper(pre, map, inLeft, inMid - 1, preLeft + 1, preLeft + (inMid - inLeft));
    root.right = helper(pre, map, inMid + 1, inRight, preRight - (inRight - inMid - 1), preRight);

    return root;
  }

  private Map<Integer, Integer> convertToMap(int[] inorder){
    Map<Integer, Integer> result = new HashMap<>();
    for(int i = 0; i < inorder.length; i++){
        result.put(inorder[i], i);
    }
    return result;
  }

}
