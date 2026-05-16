class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int ans = 0;
        Set<Character> set = new HashSet<>();

        while (j < n) {
            char ch = s.charAt(j);

            while (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(ch);
            int len = j - i + 1;
            ans = Math.max(ans, len);
            j++;
        }

        return ans;
    }
}
