class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n2 < n1) return false;

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            freq1.put(s1.charAt(i), freq1.getOrDefault(s1.charAt(i), 0) + 1);
            freq2.put(s2.charAt(i), freq2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (freq1.equals(freq2)) return true;

        for (int i = n1; i < n2; i++) {
            freq2.put(s2.charAt(i-n1), freq2.get(s2.charAt(i-n1)) - 1);
            if (freq2.get(s2.charAt(i-n1)) == 0) {
                freq2.remove(s2.charAt(i-n1));
            }

            freq2.put(s2.charAt(i), freq2.getOrDefault(s2.charAt(i), 0) + 1);

            if (freq1.equals(freq2)) return true;
        }

        return false;
    }
}
