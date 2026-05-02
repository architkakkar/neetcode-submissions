class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n1; i++) {
            int idx = s.charAt(i) - 'a';
            freq1[idx] += 1;
        }
        for (int i = 0; i < n2; i++) {
            int idx = t.charAt(i) - 'a';
            freq2[idx] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
