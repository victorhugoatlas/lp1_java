import java.util.Scanner;

class Sensor {
    int id;
    String setor;
    double temperatura;
    String status;

    public Sensor(int id, String setor, double temperatura) {
        this.id = id;
        this.setor = setor;
        this.temperatura = temperatura;
        if (temperatura < 15.0) {
            this.status = "Subresfriado";
        } else if (temperatura <= 60.0) {
            this.status = "Normal";
        } else {
            this.status = "Alerta Crítico";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        while (n <= 0 || n > 10) {
            System.out.print("Digite a quantidade de sensores (max 10): ");
            n = scanner.nextInt();
        }
        scanner.nextLine();

        Sensor[] sensores = new Sensor[n];
        double somaTemperaturas = 0;
        Sensor maiorSensor = null;

        for (int i = 0; i < n; i++) {
            System.out.println("\nSensor " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Setor: ");
            String setor = scanner.nextLine();

            System.out.print("Temperatura: ");
            double temp = scanner.nextDouble();
            scanner.nextLine();

            sensores[i] = new Sensor(id, setor, temp);
            somaTemperaturas += temp;

            if (maiorSensor == null || temp > maiorSensor.temperatura) {
                maiorSensor = sensores[i];
            }
        }

        double[][] matriz = new double[3][4];
        System.out.println("\nDigite as temperaturas da matriz 3x4 (3 sensores x 4 periodos):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("Sensor %d, Periodo %d: ", i + 1, j + 1);
                matriz[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("\n--- Medias por Periodo ---");
        for (int j = 0; j < 4; j++) {
            double somaPeriodo = 0;
            for (int i = 0; i < 3; i++) {
                somaPeriodo += matriz[i][j];
            }
            System.out.printf("Periodo %d: %.2f°C\n", j + 1, somaPeriodo / 3);
        }

        System.out.println("\n--- RELATORIO DE SENSORES ---");
        System.out.printf("%-10s %-15s %-15s %-15s\n", "ID", "Setor", "Temperatura", "Status");
        System.out.println("-------------------------------------------------------");
        for (Sensor s : sensores) {
            System.out.printf("%-10d %-15s %-15.2f %-15s\n", s.id, s.setor, s.temperatura, s.status);
        }

        System.out.println("-------------------------------------------------------");
        System.out.printf("Temperatura media geral: %.2f°C\n", somaTemperaturas / n);
        if (maiorSensor != null) {
            System.out.printf("Maior temperatura: Sensor ID %d (%s) com %.2f°C\n",
                    maiorSensor.id, maiorSensor.setor, maiorSensor.temperatura);
        }

        scanner.close();
    }
}