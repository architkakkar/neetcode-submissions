// Brute Force
// TC: O(n log n)
// SC: O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int[] arr = new int[set.size()];
        int k = 0;
        for (int num: set) {
            arr[k] = num;
            k++;
        }
        
        Arrays.sort(arr);

        int len = 1;
        int maxLen = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1] + 1) {
                len++;
            } else {
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }
        maxLen = Math.max(maxLen, len);

        return maxLen;
    }
}
/* 
2,20,4,10,3,5

2,3,4,5,10,20 len=4


*/