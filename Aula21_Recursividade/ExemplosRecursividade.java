import java.util.Scanner;

public class ExemplosRecursividade {

    public static int fatorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para calcular Fatorial e Fibonacci: ");
        int n = scanner.nextInt();

        System.out.println("Fatorial de " + n + ": " + fatorial(n));
        System.out.println("Termo " + n + " de Fibonacci: " + fibonacci(n));

        scanner.close();
    }
}