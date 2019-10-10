import java.util.*;
class SpiralMatrixII{
  public static int[][] generateMatrix(int n) {
    /**
      link: https://leetcode.com/problems/spiral-matrix-ii/
    **/
      int left = 0;
      int right = n - 1;
      int up = 0;
      int down = n - 1;
      int[][] result = new int[n][n];

      int number = 1;
      while (left <= right && up <= down){
          for(int i = left; i <= right; i++){
              result[up][i] = number++;
          }
          up++;
          for(int i = up; i <= down; i++){
              result[i][right] = number++;
          }
          right--;
          for(int i = right; i >= left; i--){
              result[down][i] = number++;
          }
          down--;
          for(int i = down; i >= up; i--){
              result[i][left] = number++;
          }
          left++;
      }
      return result;
  }

}
