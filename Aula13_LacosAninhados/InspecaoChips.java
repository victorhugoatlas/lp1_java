import java.util.Scanner;

public class InspecaoChips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int caixa = 1; caixa <= 3; caixa++) {
            boolean comprometida = false;
            System.out.println("\n--- Testando Caixa " + caixa + " ---");

            for (int chip = 1; chip <= 5; chip++) {
                System.out.print("Temperatura do Chip " + chip + " (°C): ");
                double temp = scanner.nextDouble();

                if (temp > 85.0) {
                    comprometida = true;
                    break;
                }
            }

            if (comprometida) {
                System.out.println("ALERTA: A Caixa " + caixa + " apresenta problemas e foi comprometida!");
            } else {
                System.out.println("Caixa " + caixa + " APROVADA!");
            }
        }

        scanner.close();
    }
}