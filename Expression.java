//
// Name: Chokboonanun, Saharat
// Project: 3
// Due: 3/18/2021
// Course: cs-2400-03-sp21
//
// Description:
// Learing how to use Stack to convert Infix to Postfix.
//
public class Expression {
    String[] convertToPostfix (String[] infixExpression){

        Stack<String> stack = new Stack<>(); 
        String postfix[] = new String[infixExpression.length];
        int count = 0;
        int opCount = 0;
        int numCount = 0;
       
        for(int i=0; i<infixExpression.length; i++){
            String s = infixExpression[i];
           
            char ch = s.charAt(0);

            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^")){
                opCount++;
            }

            if(Character.isDigit(ch)){
                postfix[count] = s;
                count++;
                numCount++;
            }
            else if(s.equals("(")){
                stack.push(s);
            }
            else if(s.equals(")")){
                while(!stack.peek().equals("(")){
                    postfix[count] = stack.peek();
                    count++;
                    stack.pop();
                }

                stack.pop();
            }
            else{
                if(stack.isEmpty()){
                    stack.push(s);
                }
                else{
                    int p1 = getPriority(s);
                    int p2 = getPriority(stack.peek());

                    while(p1<=p2){
                        postfix[count] = stack.peek();
                        count++;
                        stack.pop();

                        if(stack.isEmpty()){
                            p1 = 6;
                        }
                        else{
                            p2 = getPriority(stack.peek());
                        }
                    }

                    stack.push(s);
                }
       
            }

            if((numCount - opCount) > 1 || (numCount - opCount) < 0){
                throw new RuntimeException();
            } 
        }
       
        while(!stack.isEmpty()){
            if(stack.peek().equals("(")){ 
                throw new RuntimeException();
            }
            else{
                postfix[count] = stack.pop();
                count++;
            }
        }

        String postfix2[] = new String[count];

        for(int x = 0; x < postfix2.length; x++){
            String s = postfix[x];
            stack.push(s);
            postfix2[x] = stack.pop();
        }

        return postfix2;
    }

    int evaluatePostfix (String[] postfixExpression){
        
        Stack<String> stack = new Stack<>(); 
  
        for(int i=0; i<postfixExpression.length; i++){
            String s = postfixExpression[i];
            
            if(s == null){
                break;
            }

            char c = s.charAt(0);
                    
            if(Character.isDigit(c)){
                stack.push(s);
            }
            else{
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());
                            
                switch(c){
                    case '+':
                        stack.push("" + (y+x));
                        break;
                    case '-':
                        stack.push("" + (y-x));
                        break;
                    case '*':
                        stack.push("" + (y*x));
                        break;
                    case '/':
                        stack.push("" + (y/x));
                        break;
                    case '^':
                        stack.push("" + (int)Math.pow(y,x));
                        break;
                }
            }
        }
        
        return Integer.parseInt(stack.pop());
   }
  
    private int getPriority(String s){
        switch(s){
            case "^": 
                return 3;
            case "/":
            case "*": 
                return 2;
            case "+":
            case "-": 
                return 1;
            default: 
                return -1;
        }
    }

}

