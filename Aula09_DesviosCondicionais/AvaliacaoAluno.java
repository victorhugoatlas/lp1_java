import java.util.Scanner;

public class AvaliacaoAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a frequência percentual (%): ");
        double frequencia = scanner.nextDouble();

        double media = (nota1 + nota2) / 2.0;

        if (media < 6.0) {
            System.out.println("Reprovado por nota");
        } else {
            if (frequencia < 75.0) {
                System.out.println("Reprovado por falta");
            } else {
                System.out.println("Aprovado!");
            }

            if (media > 9.0) {
                System.out.println("Parabéns pelo excelente desempenho!");
            }
        }

        System.out.println("Média final: " + media);
        System.out.println("Frequência: " + frequencia + "%");

        scanner.close();
    }
}