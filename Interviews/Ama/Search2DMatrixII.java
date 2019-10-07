public class Search2DMatrixII{
  /**
    newGrad:

    link: https://leetcode.com/problems/search-a-2d-matrix-ii/
    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]
  **/

  public static boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        if(row == 0){
            return false;
        }
        int col = matrix[0].length;

        int r = row - 1;
        int c = 0;


        while(r >= 0 && c < col){
            int num = matrix[r][c];
            if(num == target){
                return true;
            }else if(num > target){
                r --;
            }else{
                c++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
      int[][] matrix = {
        {1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
      };
      System.out.println(searchMatrix(matrix, 20));
      System.out.println(searchMatrix(matrix, 12));
    }
}
