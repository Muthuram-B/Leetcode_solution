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
}/*
Example 1 — path = "/a/./b/../../c/"

Split by "/" → tokens:
["", "a", ".", "b", "..", "..", "c", ""]

Initial state:

stack = []

sb = ""

Iterate tokens in order:

token = ""

Condition: !s.equals("") fails → skip.

Stack: []

token = "a"

It's not "", not ".", not ".." → push "a".

Stack: ["a"]

token = "."

It's "." → skip.

Stack: ["a"]

token = "b"

Normal directory → push "b".

Stack: ["a", "b"]

token = ".."

It's ".." and stack not empty → pop (removes "b").

Stack: ["a"]

token = ".."

It's ".." and stack not empty → pop (removes "a").

Stack: []

token = "c"

Normal directory → push "c".

Stack: ["c"]

token = ""

Empty → skip.

Stack: ["c"]

After loop:

Stack not empty → build result by popping and inserting at front:

pop "c" → sb.insert(0,"c").insert(0,"/") → sb = "/c"

Return "/c".

Final simplified path: "/c"

Example 2 — path = "/home//foo/"

Split by "/" → tokens: ["", "home", "", "foo", ""]

Initial:

stack = []

Iterate:

"" → skip → []

"home" → push → ["home"]

"" → skip → ["home"]

"foo" → push → ["home","foo"]

"" → skip → ["home","foo"]

Build result:

pop "foo" → sb = "/foo"

pop "home" → sb = "/home/foo"

Return "/home/foo".

Final simplified path: "/home/foo"
*/