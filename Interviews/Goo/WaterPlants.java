public class WaterPlants{

  public static int waterPlants(int[] plants, int capacity1, int capacity2){

    int left = 0;
    int right = plants.length - 1;

    int count = 0;

    int leftRemain = 0;
    int rightRemain = 0;


    while(left <= right){
      if(left == right){
        if(leftRemain + rightRemain < plants[left]){
          count ++;
        }
        break;
      }

      if(leftRemain < plants[left]){
        count ++;
        leftRemain = capacity1 - plants[left];
      }else{
        leftRemain = leftRemain - plants[left];
      }
      left++;

      if(rightRemain < plants[right]){
        count ++;
        rightRemain = capacity2 - plants[right];
      }else{
        rightRemain = rightRemain - plants[right];
      }
      right --;
    }

    return count;

  }

  public static void main(String[] args) {
    int[] p1 = {2, 4, 5, 1, 2};
    int result1 = WaterPlants.waterPlants(p1, 5, 7);
    System.out.println(result1);

  }
}
