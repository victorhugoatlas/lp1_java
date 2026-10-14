import java.util.Scanner; // Importa a ferramenta do pacote utilitário

public class BubbleSortFrequencias {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double[] frequencias = new double[5];

        System.out.println("Digite as 5 frequênciaa em MHz:");
        for (int i = 0; i < 5; i++) {
            frequencias[i] = leitor.nextDouble(); 
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (frequencias[j] > frequencias[j + 1]) {
                    double aux = frequencias[j];
                    frequencias[j] = frequencias[j + 1];
                    frequencias[j + 1] = aux;
                }
            }
        }
        System.out.println("\nFrequências em ordem crescente:");
        for (int i = 0; i < 5; i++) {
            System.out.println(frequencias[i] + " MHz");
        }
        
        leitor.close();
    }
}