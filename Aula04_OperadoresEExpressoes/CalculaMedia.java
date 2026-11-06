import java.util.Scanner;

public class CalculaMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Forneça a primeira nota: ");
        double n1 = scanner.nextDouble();

        System.out.print("Forneça a segunda nota: ");
        double n2 = scanner.nextDouble();

        double media = (n1 + n2) / 2.0;

        System.out.println("A média é " + media);

        scanner.close();
    }
}