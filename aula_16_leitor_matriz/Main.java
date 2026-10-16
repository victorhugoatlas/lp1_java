public class Main {
    public static void main(String[] args) {
        double[][] matriz = {
            {1.5, 2.0, 3.5},
            {4.0, 5.5, 6.0},
            {7.5, 8.0, 9.5}
        };

        double somaTotal = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
    }
}