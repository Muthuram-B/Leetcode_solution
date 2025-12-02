class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb=new StringBuilder();
        String[] p=path.split("/");
        for(String s:p){
            if(!stack.isEmpty() && s.equals("..")){
              stack.pop();
            }
            else if(!s.equals("") && !s.equals(".") && !s.equals("..")){
            stack.push(s);
            }
        }
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop()).insert(0,"/");
        }
        return sb.toString();
    }
}