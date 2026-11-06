import java.util.Scanner;

public class AmostrasVoltagem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] voltagens = new double[6];
        double soma = 0;

        for (int i = 0; i < voltagens.length; i++) {
            System.out.print("Digite a voltagem " + i + ": ");
            voltagens[i] = scanner.nextDouble();
            soma += voltagens[i];
        }

        double media = soma / voltagens.length;
        System.out.println("Média: " + media);
        System.out.println("Acima da média:");

        for (int i = 0; i < voltagens.length; i++) {
            if (voltagens[i] > media) {
                System.out.println(voltagens[i]);
            }
        }

        scanner.close();
    }
}