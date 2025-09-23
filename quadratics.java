import java.util.Scanner;
 
public class quadratics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coefficients a, b, and c:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

       
        if (a == 0) {
            System.out.println("It is not a quadratic equation.");
            System.out.println("Please enter again:");
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
        }

        double d = (b * b - 4 * a * c);

       
        if (d == 0) {
          
            double r1 = (-b) / (2 * a);
            System.out.println("Both roots are equal.");
            System.out.println("Root: " + r1);
        } else if (d > 0) {
            
            double r1 = (-b + Math.sqrt(d)) / (2 * a);
            double r2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Roots are different.");
            System.out.println("Roots: " + r1 + " and " + r2);
        } else {
            
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-d) / (2 * a);
            System.out.println("Roots are imaginary.");
            System.out.println("Roots: " + realPart + " + " + imaginaryPart + "i and " + realPart + " - " + imaginaryPart + "i");
        }

        sc.close(); 
    }
}
