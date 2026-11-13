import java.util.Scanner;

public class DecimalParaBinario {

    public static void converterBinario(int n) {
        if (n > 1) {
            converterBinario(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número decimal inteiro positivo: ");
        int numero = scanner.nextInt();

        System.out.print("Binário: ");
        if (numero < 0) {
            System.out.print("-");
            converterBinario(-numero);
        } else {
            converterBinario(numero);
        }
        System.out.println();

        scanner.close();
    }
}