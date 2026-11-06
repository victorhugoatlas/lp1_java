import java.util.Scanner;

public class FaturaEletrica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o código da bandeira (1 - Verde, 2 - Amarela, 3 - Vermelha): ");
        int bandeira = scanner.nextInt();

        System.out.print("Digite o consumo total em kWh: ");
        double consumo = scanner.nextDouble();

        double valorTotal = 0;

        switch (bandeira) {
            case 1:
                valorTotal = consumo * 0.50;
                if (consumo > 1000.0) {
                    valorTotal *= 0.95;
                }
                System.out.println("Valor da fatura (Bandeira Verde): R$ " + valorTotal);
                break;

            case 2:
                valorTotal = consumo * 0.70;
                if (consumo > 1500.0) {
                    valorTotal *= 1.10;
                }
                System.out.println("Valor da fatura (Bandeira Amarela): R$ " + valorTotal);
                break;

            case 3:
                valorTotal = consumo * 0.95;
                if (consumo > 2000.0) {
                    valorTotal *= 1.20;
                } else if (consumo < 800.0) {
                    valorTotal *= 0.90;
                }
                System.out.println("Valor da fatura (Bandeira Vermelha): R$ " + valorTotal);
                break;

            default:
                System.out.println("Erro: Código de bandeira tarifária inválido.");
                break;
        }

        scanner.close();
    }
}