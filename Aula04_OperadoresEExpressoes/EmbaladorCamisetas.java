import java.util.Scanner;

public class EmbaladorCamisetas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade total de camisetas produzidas: ");
        int totalCamisetas = scanner.nextInt();

        int pacotesCheios = totalCamisetas / 12;
        int camisetasSobrando = totalCamisetas % 12;

        System.out.println("Pacotes cheios: " + pacotesCheios);
        System.out.println("Camisetas sobrando: " + camisetasSobrando);

        scanner.close();
    }
}