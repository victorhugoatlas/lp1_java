import java.util.Scanner;

public class OperacoesMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[2][3];
        double somaGeral = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Digite o elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextDouble();
                somaGeral += matriz[i][j];
            }
        }

        System.out.println("\n--- SOMA DAS LINHAS ---");
        for (int i = 0; i < matriz.length; i++) {
            double somaLinha = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                somaLinha += matriz[i][j];
            }
            System.out.println("Soma da Linha " + i + ": " + somaLinha);
        }

        double mediaGeral = somaGeral / (matriz.length * matriz[0].length);
        System.out.println("\nMédia Geral da Matriz: " + mediaGeral);

        scanner.close();
    }
}