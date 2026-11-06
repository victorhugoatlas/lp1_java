import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a opção de conversão:");
        System.out.println("1 - Celsius para Fahrenheit");
        System.out.println("2 - Fahrenheit para Celsius");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        System.out.print("Digite a temperatura: ");
        double tempEntrada = scanner.nextDouble();

        if (opcao == 1) {
            double tempFahrenheit = (tempEntrada * 9.0 / 5.0) + 32.0;
            System.out.println("Temperatura convertida: " + tempFahrenheit + " °F");
        } else if (opcao == 2) {
            double tempCelsius = (tempEntrada - 32.0) * 5.0 / 9.0;
            System.out.println("Temperatura convertida: " + tempCelsius + " °C");
        } else {
            System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}