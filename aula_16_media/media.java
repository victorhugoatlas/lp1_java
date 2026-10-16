public class Main {
    public static void main(String[] args) {
        String[] nomes = {"ABEL", "ANA", "BEATRIZ", "CARLA", "CARLOS", "DANIEL", "ESTHER"};
        double[][] notas = {
            {8.2, 7.2, 6.3},
            {7.1, 6.0, 8.4},
            {4.3, 8.7, 7.5},
            {6.5, 7.5, 9.8},
            {9.2, 4.6, 10.0},
            {5.2, 8.3, 7.6},
            {9.6, 8.0, 7.6}
        };

        for (int i = 0; i < nomes.length; i++) {
            double media = (notas[i][0] * 3 + notas[i][1] * 3 + notas[i][2] * 4) / 10;
            System.out.printf("%s - Média: %.2f%n", nomes[i], media);
        }
    }
}