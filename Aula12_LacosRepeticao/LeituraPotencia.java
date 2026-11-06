import java.util.Scanner;

public class LeituraPotencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int leituras = 0;
        double soma = 0;
        double maior = -Double.MAX_VALUE;

        while (true) {
            System.out.print("Digite a potência em dBm (-999 para sair): ");
            double potencia = scanner.nextDouble();

            if (potencia == -999) {
                break;
            }

            leituras++;
            soma += potencia;

            if (potencia > maior) {
                maior = potencia;
            }
        }

        if (leituras > 0) {
            System.out.println("Total de leituras válidas: " + leituras);
            System.out.println("Maior potência: " + maior + " dBm");
            System.out.println("Média das leituras: " + (soma / leituras) + " dBm");
        } else {
            System.out.println("Nenhuma leitura válida registrada.");
        }

        scanner.close();
    }
}