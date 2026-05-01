class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashSet<Integer> visited = new HashSet<Integer>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }

            String str1 = strs[i];
            HashMap<Character, Integer> freq1 = new HashMap<>();
            List<String> subList = new ArrayList<>();

            for (int k = 0; k < str1.length(); k++) {
                freq1.put(str1.charAt(k), freq1.getOrDefault(str1.charAt(k), 0) + 1);
            }

            subList.add(str1);

            for (int j = i+1; j < n; j++) {
                if (visited.contains(j)) {
                    continue;
                }

                String str2 = strs[j];
                HashMap<Character, Integer> freq2 = new HashMap<>();

                for (int k = 0; k < str2.length(); k++) {
                    freq2.put(str2.charAt(k), freq2.getOrDefault(str2.charAt(k), 0) + 1);
                }

                if (freq1.equals(freq2)) {
                    subList.add(str2);
                    visited.add(j);
                }
            }

            result.add(subList);
            visited.add(i);
        }

        return result;
    }
}
