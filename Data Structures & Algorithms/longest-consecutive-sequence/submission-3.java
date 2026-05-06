class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        
        if (n == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        for (int i = 0; i < n; i++) {
            int len = 1;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + len)) {
                    len++;
                }
            }
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }
}
