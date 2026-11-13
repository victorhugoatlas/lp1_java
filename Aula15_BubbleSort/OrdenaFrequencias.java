import java.util.Scanner;

public class OrdenaFrequencias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] frequencias = new double[5];

        for (int i = 0; i < frequencias.length; i++) {
            System.out.print("Digite a frequência " + (i + 1) + " (MHz): ");
            frequencias[i] = scanner.nextDouble();
        }

        for (int i = 0; i < frequencias.length - 1; i++) {
            for (int j = 0; j < frequencias.length - 1 - i; j++) {
                if (frequencias[j] > frequencias[j + 1]) {
                    double aux = frequencias[j];
                    frequencias[j] = frequencias[j + 1];
                    frequencias[j + 1] = aux;
                }
            }
        }

        System.out.println("\n=== FREQUÊNCIAS ORDENADAS (CRESCENTE) ===");
        for (int i = 0; i < frequencias.length; i++) {
            System.out.println(frequencias[i] + " MHz");
        }

        scanner.close();
    }
}