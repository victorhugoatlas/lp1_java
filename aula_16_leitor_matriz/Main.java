package aula_16_leitor_matriz;

public import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[3][3];
        double somaTotal = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = scanner.nextDouble();
                somaTotal += matriz[i][j];
            }
        }

        System.out.printf("Média geral: %.2f%n", somaTotal / 9);

        for (int i = 0; i < 3; i++) {
            double somaLinha = 0;
            for (int j = 0; j < 3; j++) {
                somaLinha += matriz[i][j];
            }
            System.out.printf("Soma da linha %d: %.2f%n", i + 1, somaLinha);
        }

        scanner.close();
    }
} {
    
}
