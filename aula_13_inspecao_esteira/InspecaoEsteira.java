import java.util.Scanner;

public class InspecaoEsteira {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int caixa = 1; caixa <= 3; caixa++) {
            System.out.println("Inspeção da caixa " + caixa + ":");
            
            for (int chip = 1; chip <= 5; chip++) {
                System.out.print("Digite a temperatura do chip " + chip + " (°C): ");
                double temp = scanner.nextDouble();

                if (temp > 85.0) {
                    System.out.println("Alerta: A caixa " + caixa + " apresenta problemas!");
                    break;
                }
            }
        }
        scanner.close();
    }
}