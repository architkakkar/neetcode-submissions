class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if (n2 > n1) return "";

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n2; i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        if (isValidSubstring(map1, map2)) return s.substring(0, n2);

        int l = 0, r = n2;
        int start = 0, end = 0, minLen = Integer.MAX_VALUE;

        while (r < n1) {
            map1.put(s.charAt(r), map1.getOrDefault(s.charAt(r), 0) + 1);

            while (isValidSubstring(map1, map2)) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    start = l;
                    end = r;
                }
                
                map1.put(s.charAt(l), map1.get(s.charAt(l)) - 1);
                if (map1.get(s.charAt(l)) == 0) map1.remove(s.charAt(l));

                l++;
            }
            
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end+1);
    }

    public boolean isValidSubstring(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        boolean isValid = true;

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            char key = entry.getKey();
            int freq = entry.getValue();

            if (!map1.containsKey(key) || map1.get(key) < freq) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}
