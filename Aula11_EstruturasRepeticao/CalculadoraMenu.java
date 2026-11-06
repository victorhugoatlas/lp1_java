import java.util.Scanner;

public class CalculadoraMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Calculadora Simples ===");
            System.out.println("1. Somar");
            System.out.println("2. Subtrair");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 4) {
                System.out.print("Digite o primeiro número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Digite o segundo número: ");
                double num2 = scanner.nextDouble();

                if (opcao == 1) {
                    System.out.println("Resultado: " + (num1 + num2));
                } else if (opcao == 2) {
                    System.out.println("Resultado: " + (num1 - num2));
                } else if (opcao == 3) {
                    System.out.println("Resultado: " + (num1 * num2));
                } else if (opcao == 4) {
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Erro: Divisão por zero!");
                    }
                }
            } else if (opcao != 5) {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}