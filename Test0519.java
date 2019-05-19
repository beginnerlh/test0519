/*给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
[1,3,1],
[1,5,1],
[4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。*/
package lianxi0519;

public class Test0519 {
    public static void main(String[] args) {
        Solution s =new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(s.minPathSum(grid));
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] nums = new int[m][n];
        nums[0][0] = grid[0][0];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j==0){
                    if(i==0 && j !=0){
                        nums[i][j] = nums[i][j-1] + grid[i][j];
                    }else if(i != 0 && j == 0){
                        nums[i][j] = nums[i-1][j] + grid[i][j];
                    }
                }else{
                    nums[i][j] = Math.min(nums[i-1][j],nums[i][j-1]) + grid[i][j];
                }
            }
        }
        return nums[m-1][n-1];
    }
}