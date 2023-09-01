import java.util.*;

public class Calculator {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a = ");
            double a = sc.nextDouble();

            System.out.print("Enter b = ");
            double b = sc.nextDouble();

            System.out.print("Enter operator = ");
            char operator = sc.next().charAt(0);
                
            switch(operator) {
                case '+' : System.out.println(a+b);
                            break;
                case '-' : System.out.println(a-b);
                            break;
                case '*' : System.out.println(a*b);
                            break;
                case '/' : if(b==0) {
                                System.out.println("denominator cannot be 0");
                            }
                            else {
                                System.out.println(a/b);
                            }
                            break;
                case '%' : System.out.println(a%b);
                            break;
                default : System.out.println("Error");

            }
        }
    
    }
    
}
