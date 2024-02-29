public class MaximumPathSumHard {
  private int maxSum;

  public int solve(TreeNode root){
    if(root == null ) return 0;
    int leftSum = solve(root.left);
    int rightSum = solve(root.right);

    //Case 1 -> Where we get the best path
    int max1 = leftSum + rightSum + root.val;

    //Case 2 -> Where we calculate maxPath either left or right. If left is -ve then right and vice versa.
    int max2 = Math.max(leftSum , rightSum) + root.val;

    //Case 3 -> left and right are both negative;
    int max3 = root.val;
    maxSum = Math.max(maxSum , Math.max(Math.max(max1 ,max2) , max3));
    return Math.max(max2 , max3);

  }
  public int maxPathSum(TreeNode root) {
    maxSum = Integer.MIN_VALUE;
    solve(root);
    return maxSum;
  }
}
