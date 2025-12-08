import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = new ArrayList<>();
        for (int n : nums) {
            input.add(n);
        }

        return permuteList(new ArrayList<Integer>(), input);
    }

    private List<List<Integer>> permuteList(List<Integer> p, List<Integer> up) {
        if (up.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(p));
            return ans;
        }

        int ch = up.get(0);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= p.size(); i++) {
            List<Integer> f = new ArrayList<>(p);
            f.add(i, ch);
            res.addAll(permuteList(f, up.subList(1, up.size())));
        }

        return res;
    }
}
