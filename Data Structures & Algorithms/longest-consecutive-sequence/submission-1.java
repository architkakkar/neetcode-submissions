class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            else {
                int len = 1, k = 1;
                while (set.contains(nums[i] + k)) {
                    k++;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
