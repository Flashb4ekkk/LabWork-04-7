
import java.text.DecimalFormat;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x, a, R = 0, S = 0;
        double arctanh = 0;
        int n;
        System.out.print("xp = ");
        double xp = scanner.nextDouble();
        System.out.print("xk = ");
        double xk = scanner.nextDouble();
        System.out.print("dx = ");
        double dx = scanner.nextDouble();
        System.out.print("eps = ");
        double eps = scanner.nextDouble();
        DecimalFormat df3 = new DecimalFormat("0.000");

        System.out.println("-------------------------------------------------");
        System.out.println("| " + String.format("%9s", "x") + " | " + String.format("%9s", "arcth(x)") + " | " + String.format("%9s", "S") + " | " + String.format("%9s", "n") + " |");
        System.out.println("-------------------------------------------------");
        x = xp;


        while (x <= xk) {
            n = 1;
            a = x; // !
            S = a;
            do {
                n++;
                R = a / (2 * n + 1); // !
                a *= -x * x; // !
                S += R; //! + a
            } while (Math.abs(R) >= eps);

//            n = 1;
//            a = 1 / x;
//            S = a;
//            do {
//                n++;
//                R = (2 * n - 1) / (2 * n * Math.pow(x, 2) + Math.pow(x, 2));
//                a *= R;
//                S += a;
//            } while (Math.abs(R) >= eps);

            arctanh = Math.log((1 + x) / (1 - x)) / 2;
            System.out.println(String.format("| %9.2f | %9.4f | %9.4f | %9s |", x, arctanh, S, n));
            x += dx;
        }
        System.out.println("-------------------------------------------------");
    }
}
