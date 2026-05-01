// pLeft =  [1,2,8,48]
// pRight = [48,48,24,6]
// ans =    [48,24,12,8]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prodLeft = new int[n];
        int[] prodRight = new int[n];

        prodLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prodLeft[i] = prodLeft[i-1] * nums[i];
        }

        prodRight[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            prodRight[i] = prodRight[i+1] * nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[i] = prodRight[i+1];
            }
            else if (i == n-1) {
                ans[i] = prodLeft[i-1];
            } else {
                ans[i] = prodLeft[i-1] * prodRight[i+1];
            }
        }

        return ans;
    }
}  
