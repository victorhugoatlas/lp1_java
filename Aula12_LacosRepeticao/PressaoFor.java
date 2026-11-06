import java.util.Scanner;

public class PressaoFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double soma = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Leitura " + i + " de pressão (PSI): ");
            soma += scanner.nextDouble();
        }

        System.out.println("Soma total: " + soma + " PSI");
        System.out.println("Média: " + (soma / 5) + " PSI");

        scanner.close();
    }
}