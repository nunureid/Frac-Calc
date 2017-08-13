import java.util.*;
public class FracCalc {

   public static void main(String[] args){
      //Scan input until "quit" is entered. Program should exit if quit is entered
      Scanner kbd = new Scanner( System.in );
      //variable store one line of input
      String line = "";
     
      //while(true) {
         //get 1 line of input from the keyborad
         System.out.print(" Give me an equation: ");
         line = kbd.nextLine();
         //compare the input of the word quit
        /* if (line.equalsIgnoreCase("quit")) {
            break;
         }//end   */
         String result = produceAnswer(line);
         System.out.println("Second Operand of " + line + " is " + result);
        
     
    //  }//end of while loop
     
      System.out.println("Thank you for using my calculator");
   
  
   }//end of main
   public static String produceAnswer(String line) {
     //Tokenize the input into left, opertor and right parts
      int b1 = line.indexOf( ' ' );
      //System.out.println("First blank space is at index " + b1);
      //First number is between 0 andb1
      String strNum1 = line.substring(0,b1);
      //int num1 = Integer.parseInt(strNum1);
      //operator is at location b1 + 1
      char operator = line.charAt(b1+1);
      //2nd number is at b1 +3 till end of line
      String strNum2 = line.substring(b1+3);
      //int num2 = Integer.parseInt(strNum2);
      return strNum2;
     
      //int result = 0;
      /*if(operator == '+') {
         result = num1 + num2;
     } else if ( operator  == '-'){
         result = num1 - num2;
         }
      else if (operator == '*'){
            result = num1 * num2;
         }
      else if (operator == '/'){
      result = num1 / num2;
     }  
      return result ;  */
      }//end of produceAnswer
   }//end of Calculator
