import java.util.Scanner;

public class Divisores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        int i = numero;
        System.out.print("Divisores: ");
        while (i >= 1) {
            if (numero % i == 0) {
                System.out.print(i + (i > 1 ? ", " : ""));
            }
            i--;
        }
        System.out.println();

        scanner.close();
    }
}