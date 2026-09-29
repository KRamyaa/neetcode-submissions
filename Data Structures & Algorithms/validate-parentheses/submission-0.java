class Solution {
    public boolean isValid(String s) {
        
        char[] characters = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: characters){
            if(c == '(' || c == '{' || c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char recent = stack.peek();
                if((c == ')' && recent == '(') || (c == '}' && recent == '{') || (c == ']' && recent == '[')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
