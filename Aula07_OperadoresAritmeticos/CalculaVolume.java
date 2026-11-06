import java.util.Scanner;

public class CalculaVolume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a altura do bloco (cm): ");
        double altura = scanner.nextDouble();

        System.out.print("Digite a largura do bloco (cm): ");
        double largura = scanner.nextDouble();

        System.out.print("Digite a profundidade do bloco (cm): ");
        double profundidade = scanner.nextDouble();

        double volume = altura * largura * profundidade;

        System.out.println("Volume total do bloco: " + volume + " cm³");

        scanner.close();
    }
}