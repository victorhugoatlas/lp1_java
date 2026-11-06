import java.util.Scanner;

public class VerificaIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ano de nascimento: ");
        int anoNascimento = scanner.nextInt();

        System.out.print("Digite o ano atual: ");
        int anoAtual = scanner.nextInt();

        int idade = anoAtual - anoNascimento;

        System.out.println("Idade: " + idade + " anos");

        if (idade >= 18) {
            System.out.println("Status: Maior de idade");
        } else {
            System.out.println("Status: Menor de idade");
        }

        scanner.close();
    }
}