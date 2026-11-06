import java.util.Scanner;

public class CalibracaoSensor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean calibrado = false;

        for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.print("Digite o offset (1.0 a 5.0) - Tentativa " + tentativa + ": ");
            double offset = scanner.nextDouble();

            if (offset >= 1.0 && offset <= 5.0) {
                calibrado = true;
                break;
            }
        }

        if (calibrado) {
            System.out.println("Calibração confirmada com sucesso!");
        } else {
            System.out.println("ALERTA: Sistema bloqueado! 3 tentativas esgotadas.");
        }

        scanner.close();
    }
}