import java.util.Scanner;

public class BasicCalculator {
    public static double add(double a,double b){return a+b;}
    public static double sub(double a,double b){return a-b;}
    public static double mul(double a,double b){return a*b;}
    public static double div(double a,double b){return a/b;}

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter op (+ - * /) and two numbers: ");
            String op = sc.next(); double a = sc.nextDouble(), b = sc.nextDouble();
            switch(op) {
                case "+": System.out.println(add(a,b)); break;
                case "-": System.out.println(sub(a,b)); break;
                case "*": System.out.println(mul(a,b)); break;
                case "/": System.out.println(div(a,b)); break;
                default: System.out.println("Unknown op");
            }
        }
    }
}
