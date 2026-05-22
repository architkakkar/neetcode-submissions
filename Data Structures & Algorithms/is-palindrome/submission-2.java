class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;

        while (i <= j) {
            while (i < n && !isAlphaNumeric(Character.toLowerCase(s.charAt(i)))) {
                i++;
            }
            while (j >= 0 && !isAlphaNumeric(Character.toLowerCase(s.charAt(j)))) {
                j--;
            }

            if (i < n && j >= 0 && (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean isAlphaNumeric(char ch) {
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
            return true;
        }

        return false;
    }
}
