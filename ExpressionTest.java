//
// Name: Chokboonanun, Saharat
// Project: 3
// Due: 3/18/2021
// Course: cs-2400-03-sp21
//
// Description:
// Learing how to use Stack to convert Infix to Postfix.
//

public class ExpressionTest {
   public static void main (String[] args){
      System.out.println("Converting Infix to Postfix by Saharat Chokboonanun");
      System.out.println();

      String case1 = "( 1 + 1 ) * ( 1 + 1 )";
      String case2 = "( 1 + 1 ) * (";
      String case3 = "( 1 + 1 ) * ( a / 3 )";
      String case4 = "2 + 5 - 1 * 4 / 2 ^ 2";
      String case5 = "2 + 5 - 1 1 * 4 / 2 ^";
      String case6 = "2 + 5 - - 1 * 4 / 2 ^ ";
      String case7 = "2 + 5 - 1 ) * 4 / 2 ";

      functions(case1);
      functions(case2);
      functions(case3);
      functions(case4);
      functions(case5);
      functions(case6);
      functions(case7);

   }

   public static void functions(String equ){
      Expression exp = new Expression();
      System.out.println("Case");
      String s[] = equ.split(" ");
   
      System.out.print("Infix expression: ");

      for(int x = 0; x < s.length; x++){
         System.out.print(s[x] + " ");
      }

      System.out.println();
      System.out.print("Postfix expression: ");

      try{
         String w[] = exp.convertToPostfix(s);
         
         for(int x = 0; x < w.length ; x++){
            System.out.print(w[x] + " ");
         }
         System.out.println();

         System.out.print("Evaluate Postfix: ");
         System.out.println(exp.evaluatePostfix(w) + "\n");
         
      }catch(RuntimeException e){
         System.out.println("Stack is not well-formed");
         System.out.println("Evaluate Postfix: Can't Evaluate\n");
      } 
   }

   public static void mystery (int x)
{
   System.out.print(x % 10);

   if ((x / 10) != 0)
   {
      mystery(x / 10);
   }
   System.out.print(x % 10);
}

}
