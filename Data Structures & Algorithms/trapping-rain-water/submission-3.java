class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;

        int[] pLeft = new int[n];
        int[] pRight = new int[n];

        pLeft[0] = height[0];
        pRight[n-1] = height[n-1];

        for (int i = 1; i < n; i++) {
            pLeft[i] = Math.max(pLeft[i-1], height[i]);
        }

        for (int i = n-2; i >= 0; i--) {
            pRight[i] = Math.max(pRight[i+1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int mn = Math.min(pLeft[i], pRight[i]);
            water += mn - height[i];
        }

        return water;
    }
}
/*
height = 0,2,0,3,1,0,1,3,2,1
pLeft  = 0,2,2,3,3,3,3,3,3,3
pRight = 3,3,3,3,3,3,3,3,2,1

height = 0,2,0,3,1,0,1,3,2,1
mn     = 0,2,2,3,3,3,3,3,2,1
diff   = 0,0,2,0,2,3,2,0,0,0 = 9 (ans)
*/