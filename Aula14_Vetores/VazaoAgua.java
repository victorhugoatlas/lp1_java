import java.util.Scanner;

public class VazaoAgua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] vazoes = new double[5];

        for (int i = 0; i < vazoes.length; i++) {
            System.out.print("Digite a vazão " + i + ": ");
            vazoes[i] = scanner.nextDouble();
        }

        int iMaior = 0;
        int iMenor = 0;

        for (int i = 1; i < vazoes.length; i++) {
            if (vazoes[i] > vazoes[iMaior]) {
                iMaior = i;
            }
            if (vazoes[i] < vazoes[iMenor]) {
                iMenor = i;
            }
        }

        System.out.println("Maior valor: " + vazoes[iMaior] + " no índice " + iMaior);
        System.out.println("Menor valor: " + vazoes[iMenor] + " no índice " + iMenor);

        scanner.close();
    }
}