class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack =new Stack<>();
        for(String token:tokens){
            if(isOperator(token)){
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int result=0;
                if(token.equals("+")){
                    result=num1+num2;
                }else if(token.equals("-")){
                    result=num1-num2;
                }else if(token.equals("*")){
                    result=num1*num2;
                }else if(token.equals("/")){
                    result=num1/num2;
                }
                stack.push(Integer.toString(result));
            }else{
                   stack.push(token);
            }
        }
            return Integer.parseInt(stack.peek());
        }
        private boolean isOperator(String s){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                return true;
            }
            return false;
        }
    }
/* it return the result in the form of expression in the postfix form that is it can be represented as 2,1,+,3,*
in this intially 2 is pushed then 1 is pushed after that it sees + it is an operator so it pop out the value 2 and 1 and then add it 2+1=3  then add it to stack after that push 3 in to stack then * operator then pop 3 and 3 from stack and do 3*3=9 and push into stack and pop 9*/