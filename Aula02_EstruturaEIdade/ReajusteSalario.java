import java.util.Scanner;

public class ReajusteSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do salário atual: ");
        double salario = scanner.nextDouble();

        if (salario < 2000.0) {
            salario = salario * 1.10;
        }

        System.out.println("Novo salário: R$ " + salario);

        scanner.close();
    }
}