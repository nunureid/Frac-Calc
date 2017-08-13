import java.util.*;
public class FracCalc2 {

      public static int w1=0; 
      public static int n1=0;
      public static int d1=1;
      public static int w2=0;
      public static int n2=0;
      public static int d2=0;
      
      public static int A1=0;
      public static int B1=1;
      public static int S1=1;
     
      public static int A2=0;
      public static int B2=1;
      public static int S2=1;

      

   public static void main(String[] args){
      //Scan input until "quit" is entered. Program should exit if quit is entered
      Scanner kbd = new Scanner( System.in );
      //variable store one line of input
      String line = "";
     
      while(true) {
         //get 1 line of input from the keyborad
         System.out.print(" Give me an equation: ");
         line = kbd.nextLine();
         //compare the input of the word quit
         if (line.equalsIgnoreCase("quit")) {
            break;
         }//end
         String result = produceAnswer(line);
         System.out.println(line + " is " + result);
        
     
      }//end of while loop
     
      System.out.println("Thank you for using my calculator");
   
  
   }//end of main
   
   public static String produceAnswer(String line) {
     //Tokenize the input into left, opertor and right parts
      int b1 = line.indexOf( ' ' );
      //System.out.println("First blank space is at index " + b1);
      //First number is first operand
      String strNum1 = line.substring(0,b1);
      //int num1 = Integer.parseInt(strNum1);
      //operator is at location b1 + 1
      char operator = line.charAt(b1+1);
      //2nd number is at b1 +3 till end of line; 2nd operand
      String strNum2 = line.substring(b1+3);
      //int num2 = Integer.parseInt(strNum2);
     

 
      //tokenize the strNum1 with w1, n1, d1
      int underScore1 = strNum1.indexOf('_');
      int slash1 = strNum1.indexOf('/');
  
      // tokenize the strNum2 with w2, n2, d2
      int underScore2 = strNum2.indexOf('_');
      int slash2 = strNum2.indexOf('/');
      
      // parse operand1 into w1, n1, d1, s1
      boolean isOperand1 = true;
      stringToFrac(strNum1,isOperand1);
      convert(w1,n1,d1,isOperand1);

      
      // parse operand2 into w2, n2, d2, s2
      isOperand1 = false;
      stringToFrac(strNum2,isOperand1);
      convert(w2,n2,d2,isOperand1);

            
      // print the global values
      System.out.println("w1 = " + w1 + " n1 = " + n1 + " d1 = " + d1);
      System.out.println("w2 = " + w2 + " n2 = " + n2 + " d2 = " + d2);
      
      System.out.println("A1 = " + A1 + " B1 = " + B1);
      System.out.println("A2 = " + A2 + " B2 = " + B2);
      

      

      
      //strNum1;
      //strNum2;
     
      String result = "The answer for equation.";
      if(operator == '+') {
         result = add();
     } else if ( operator  == '-'){
         result = subtract();
         }
      else if (operator == '*'){
            result = multiply();
         }
      else if (operator == '/'){
      result = divide();
     }  
      return result ;   
      
      }//end of produceAnswer
      
      public static void stringToFrac(String input, boolean isNum) {
         int w = 0, n = 0, d = 1;
         int t1 = input.indexOf('_');
         int t2 = input.indexOf('/');
         
         if(t1<0 && t2<0){ // whole number only
            w = Integer.parseInt(input);
         } 
         else if (t1 < 0 && t2 >= 0) { // parse fraction only
            String left = input.substring(0, t2);
          //String right = input.substring(t2,1);
            String right = input.substring(t2+1);

            n = Integer.parseInt(left);
            d = Integer.parseInt(right);
         }
         else {
            String left = input.substring(0,t1);
            String mid  = input.substring(t1+1,t2);
      //    String right = input.substring(t2+1);
            String right = input.substring(t2+1);
            
            
            w  = Integer.parseInt(left);
            n  = Integer.parseInt(mid);
            d  = Integer.parseInt(right);
         }  // end of if test conditions
         
         if(isNum){
            w1 = w;
            n1 = n;
            d1 = d;
         }
         else {
            w2 = w;
            n2 = n;
            d2 = d;
         }     
      } // end of method stringToFrac
      
      public static void convert(int whole, int numerator, int denominator, boolean isOperand){
         int s = 1;
         if (whole < 0){
            s = -1;
            whole = whole*s;
         }
         if (isOperand) {
            A1 = whole*denominator + numerator;
            B1 = denominator;
            S1 = s;
         }
         else{
            A2 = whole*denominator + numerator;
            B2 = denominator;
            S2 = s;
         }   
      
      } // end of method convert
      
      public static int gcd(int a, int b) {
      
         if(b==0){
            return a;
         }
         return gcd(b, (a%b));
      }// end of method gcd
      
      public static String add(){
         int A;
         int B;
         
         A = S1*(A2*B1) + S2*(A1*B2);
         B = B1*B2;
         System.out.println("A = " + A);
         System.out.println("B = " + B);
         
         String result = Integer.toString(A)+'/'+Integer.toString(B);

         return result;
      } // end of method add
               
               
      public static String subtract() {
         int A;
         int B;
         
         A = S1*(A2*B1) - S2*(A1*B2);
         B = B1*B2;
         System.out.println("A = " + A);
         System.out.println("B = " + B);
         
         String result = Integer.toString(A)+'/'+Integer.toString(B);

         return result;
      }   // end of method subtract
      
      public static String multiply() {
         int A;
         int B;
         
         A = S1*A1*S2*A2;
         B = B1*B2;
         System.out.println("A = " + A);
         System.out.println("B = " + B);
         
         String result = Integer.toString(A)+'/'+Integer.toString(B);

         return result;
      }   // end of method multiply
      
      public static String divide() {
         int A;
         int B;
         
         A = S1*A1*S2*B2;
         B = B1*A2;
         System.out.println("A = " + A);
         System.out.println("B = " + B);
         
         String result = Integer.toString(A)+'/'+Integer.toString(B);

         return result;
      }   // end of method divide
      
      
                
      
   }//end of Frac Calculator