import java.util.Scanner;

public class PressaoDoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        int i = 1;

        do {
            System.out.print("Leitura " + i + " de pressão (PSI): ");
            soma += scanner.nextDouble();
            i++;
        } while (i <= 5);

        System.out.println("Soma total: " + soma + " PSI");
        System.out.println("Média: " + (soma / 5) + " PSI");

        scanner.close();
    }
}