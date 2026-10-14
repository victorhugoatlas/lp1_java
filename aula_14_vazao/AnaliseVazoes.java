import java.util.Scanner;

public class AnaliseVazoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] vazoes = new double[5];
        
        vazoes[0] = scanner.nextDouble();
        double maior = vazoes[0];
        double menor = vazoes[0];
        int indiceMaior = 0;
        int indiceMenor = 0;

        for (int i = 1; i < 5; i++) {
            vazoes[i] = scanner.nextDouble();
            if (vazoes[i] > maior) {
                maior = vazoes[i];
                indiceMaior = i;
            }
            if (vazoes[i] < menor) {
                menor = vazoes[i];
                indiceMenor = i;
            }
        }

        System.out.println("Maior valor: " + maior + " no indice " + indiceMaior);
        System.out.println("Menor valor: " + menor + " no indice " + indiceMenor);
    }
}