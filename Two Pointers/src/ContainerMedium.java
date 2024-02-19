public class ContainerMedium {

  public int maxArea(int[] height){
    int res = 0;
    int area;
    int i = 0;
    int j = height.length - 1;

    while(i < j){
      area = Math.min(height[i] , height[j]) * (j-i);
      res = Math.max(res , area);

      if(height[i] <= height[j]){
        i++;
      }
      else {
        j--;
      }
    }
    return res;

  }
  public static void main(String[] args) {
    ContainerMedium solver = new ContainerMedium();
    System.out.println(solver.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
  }
}
