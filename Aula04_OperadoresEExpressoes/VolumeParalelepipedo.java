import java.util.Scanner;

public class VolumeParalelepipedo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a unidade de medida (ex: cm, m): ");
        String unidade = scanner.next();

        System.out.print("Digite a altura: ");
        double altura = scanner.nextDouble();

        System.out.print("Digite a largura: ");
        double largura = scanner.nextDouble();

        System.out.print("Digite a profundidade: ");
        double profundidade = scanner.nextDouble();

        double volume = altura * largura * profundidade;

        System.out.println("Volume: " + volume + " " + unidade + " cúbicos");

        scanner.close();
    }
}