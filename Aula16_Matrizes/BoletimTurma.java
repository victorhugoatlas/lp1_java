public class BoletimTurma {
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

        System.out.println("NOME\t\tN1\tN2\tN3\tMÉDIA");
        for (int i = 0; i < nomes.length; i++) {
            double n1 = notas[i][0];
            double n2 = notas[i][1];
            double n3 = notas[i][2];
            
            double media = (n1 * 3 + n2 * 3 + n3 * 4) / 10.0;
            
            System.out.printf("%-10s\t%.1f\t%.1f\t%.1f\t%.2f\n", nomes[i], n1, n2, n3, media);
        }
    }
}