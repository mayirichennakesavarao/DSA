class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push('(');
            }else{
                //check the next one ')'
                if(i+1 < s.length() && s.charAt(i + 1) == ')'){
                    i++;
                }else{
                    insertions++;
                }
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    insertions++;
                }
            }
           
        }
        insertions += stack.size() *2;
        return insertions;
    }
}