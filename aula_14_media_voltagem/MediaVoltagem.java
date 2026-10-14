import java.util.Scanner;

public class MediaVoltagem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] voltagens = new double[6];
        double soma = 0;

        for (int i = 0; i < 6; i++) {
            voltagens[i] = scanner.nextDouble();
            soma += voltagens[i];
        }

        double media = soma / 6;

        for (int i = 0; i < 6; i++) {
            if (voltagens[i] > media) {
                System.out.println(voltagens[i]);
            }
        }
    }
}