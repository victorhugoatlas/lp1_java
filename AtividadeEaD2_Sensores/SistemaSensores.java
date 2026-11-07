import java.util.Scanner;

/**
 * Classe principal responsável pela execução do console interativo,
 * gerenciamento do vetor de objetos Sensor, calculo da matriz 3x4 de temperaturas
 * por períodos e exibição do relatório formatado.
 * 
 * @author Victor Hugo
 * @version 1.0
 */
public class SistemaSensores {

    /**
     * Método principal de execução do sistema.
     * 
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantidade = 0;
        while (quantidade <= 0 || quantidade > 10) {
            System.out.print("Informe a quantidade de sensores para cadastrar (máximo 10): ");
            quantidade = scanner.nextInt();
            scanner.nextLine();
        }

        Sensor[] redeSensores = new Sensor[quantidade];

        System.out.println("\n--- CADASTRO DOS SENSORES DA REDE ---");
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nSensor " + (i + 1) + ":");
            
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Setor: ");
            String setor = scanner.nextLine();

            System.out.print("Temperatura (°C): ");
            double temperatura = scanner.nextDouble();
            scanner.nextLine();

            redeSensores[i] = new Sensor(id, setor, temperatura);
        }

        System.out.println("\n--- ENTRADA DE DATOS DA MATRIZ TÉRMICA DIÁRIA (3 Sensores x 4 Períodos) ---");
        double[][] matrizTermica = new double[3][4];

        for (int s = 0; s < 3; s++) {
            System.out.println("Leituras para o Sensor Matriz [" + (s + 1) + "]:");
            for (int p = 0; p < 4; p++) {
                System.out.print("  Período " + (p + 1) + " (°C): ");
                matrizTermica[s][p] = scanner.nextDouble();
            }
        }

        System.out.println("\n=== MÉDIAS DE TEMPERATURA POR PERÍODO DO DIA (MATRIZ) ===");
        for (int p = 0; p < 4; p++) {
            double somaPeriodo = 0;
            for (int s = 0; s < 3; s++) {
                somaPeriodo += matrizTermica[s][p];
            }
            double mediaPeriodo = somaPeriodo / 3.0;
            System.out.printf("Período %d: %.2f °C\n", (p + 1), mediaPeriodo);
        }

        double somaGeral = 0;
        int indexMaiorTemp = 0;

        System.out.println("\n==========================================================");
        System.out.println("            RELATÓRIO DETALHADO DA REDE DE SENSORES       ");
        System.out.println("==========================================================");
        System.out.printf("%-10s | %-15s | %-15s | %-15s\n", "ID", "SETOR", "TEMPERATURA", "STATUS");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < quantidade; i++) {
            Sensor sensor = redeSensores[i];
            somaGeral += sensor.getTemperatura();

            if (sensor.getTemperatura() > redeSensores[indexMaiorTemp].getTemperatura()) {
                indexMaiorTemp = i;
            }

            System.out.printf("%-10d | %-15s | %-15.2f | %-15s\n",
                    sensor.getId(),
                    sensor.getSetor(),
                    sensor.getTemperatura(),
                    sensor.getStatus());
        }

        double mediaGeral = somaGeral / quantidade;
        Sensor sensorMaisQuente = redeSensores[indexMaiorTemp];

        System.out.println("----------------------------------------------------------");
        System.out.printf("Temperatura Média Geral da Rede: %.2f °C\n", mediaGeral);
        System.out.printf("Sensor com Temperatura Mais Alta: ID %d (Setor: %s) com %.2f °C\n",
                sensorMaisQuente.getId(),
                sensorMaisQuente.getSetor(),
                sensorMaisQuente.getTemperatura());
        System.out.println("==========================================================");

        scanner.close();
    }
}