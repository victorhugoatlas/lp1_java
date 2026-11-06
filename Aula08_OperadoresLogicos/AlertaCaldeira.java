import java.util.Scanner;

public class AlertaCaldeira {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a temperatura da água (°C): ");
        double temperatura = scanner.nextDouble();

        System.out.print("Digite a pressão interna (atm): ");
        double pressao = scanner.nextDouble();

        boolean dispararAlerta = temperatura > 120.0 && pressao > 5.0;

        System.out.println("Alerta disparado: " + dispararAlerta);

        scanner.close();
    }
}