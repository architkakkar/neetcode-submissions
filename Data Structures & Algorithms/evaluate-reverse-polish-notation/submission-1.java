class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Deque<Integer> st = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Set.of("+", "-", "/", "*"));

        for (int i = 0; i < n; i++) {
            String token = tokens[i];

            if (set.contains(token)) {
                int operand2 = st.pop();
                int operand1 = st.pop();

                if (token.equals("+")) {
                    st.push(operand1 + operand2);
                } else if (token.equals("-")) {
                    st.push(operand1 - operand2);
                } else if (token.equals("*")) {
                    st.push(operand1 * operand2);
                } else {
                    st.push(operand1 / operand2);
                }
            } else {
                st.push(Integer.valueOf(token));
            }
        }

        return st.pop();
    }
}
