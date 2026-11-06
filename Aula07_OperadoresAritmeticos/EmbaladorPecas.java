import java.util.Scanner;

public class EmbaladorPecas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade total de peças produzidas: ");
        int totalPecas = scanner.nextInt();

        int caixasCheias = totalPecas / 12;
        int pecasAvulsas = totalPecas % 12;

        System.out.println("Quantidade de caixas cheias: " + caixasCheias);
        System.out.println("Quantidade de peças avulsas: " + pecasAvulsas);

        scanner.close();
    }
}