public class MinimumDominoRotations{

  public static int minDominoRotations(int[] A, int[] B) {

          int times1 = rotateTo(A[0], A, B);
          int times2 = rotateTo(B[0], A, B);
          if(times1 == -1 && times2 == -1){
              return -1;
          }
          if(times1 != -1 && times2 != -1){
              return Math.min(times1, times2);
          }
          return times1 == -1  ? times2: times1;
      }

      private static int rotateTo(int target, int[] A, int[] B){
          int res1 = A.length;
          int res2 = B.length;

          for(int i = 0; i < A.length; i++){
              if(target != A[i] && target != B[i]){
                  return -1;
              }
              if(target == A[i]){
                  res1 --;
              }
              if(target == B[i]){
                  res2 --;
              }
          }

          return Math.min(res1, res2);

      }

  public static void main(String[] args) {
    int[] A1 = {3,5,1,2,3};
    int[] B1 = {3,6,3,3,4};
    int result1 = MinimumDominoRotations.minDominoRotations(A1, B1);
    System.out.println(result1);

    int[] A2 = {2,1,2,4,2,2};
    int[] B2 = {5,2,6,2,3,2};
    int result2 = MinimumDominoRotations.minDominoRotations(A2, B2);
    System.out.println(result2);
  }


}
