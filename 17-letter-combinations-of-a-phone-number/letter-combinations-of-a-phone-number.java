class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        return solve("", digits);
    }

    private List<String> solve(String p, String up) {
        // Base Case
        if (up.isEmpty()) {
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        // Get the digit
        int digit = up.charAt(0) - '0';

        // Mapping for letters on keypad
        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        String letters = mapping[digit];

        List<String> res = new ArrayList<>();

        // Generate combinations
        for (char ch : letters.toCharArray()) {
            res.addAll(solve(p + ch, up.substring(1)));
        }

        return res;
    }
}
