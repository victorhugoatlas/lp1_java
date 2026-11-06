import java.util.Scanner;

public class PressaoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        int i = 1;

        while (i <= 5) {
            System.out.print("Leitura " + i + " de pressão (PSI): ");
            soma += scanner.nextDouble();
            i++;
        }

        System.out.println("Soma total: " + soma + " PSI");
        System.out.println("Média: " + (soma / 5) + " PSI");

        scanner.close();
    }
}