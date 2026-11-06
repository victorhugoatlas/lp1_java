import java.util.Scanner;

public class GerenciadorSessoesRefatorado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SessaoUsuario[] sessoes = new SessaoUsuario[3];

        for (int i = 0; i < sessoes.length; i++) {
            sessoes[i] = new SessaoUsuario();

            System.out.println("\n--- Cadastro da Sessão " + (i + 1) + " ---");
            
            System.out.print("Token: ");
            sessoes[i].token = scanner.nextLine();

            System.out.print("Usuário: ");
            sessoes[i].usuario = scanner.nextLine();

            System.out.print("Tempo de inatividade (minutos): ");
            sessoes[i].tempoInatividadeMin = scanner.nextInt();

            System.out.print("Sessão expirada? (true/false): ");
            sessoes[i].expirada = scanner.nextBoolean();
            
            scanner.nextLine();
        }
        System.out.println("\n=== SESSÕES CADASTRADAS ===");
        for (int i = 0; i < sessoes.length; i++) {
            System.out.println("\nSessão " + (i + 1) + ":");
            System.out.println("Usuário: " + sessoes[i].usuario);
            System.out.println("Token: " + sessoes[i].token);
            System.out.println("Inatividade: " + sessoes[i].tempoInatividadeMin + " min");
            System.out.println("Status: " + (sessoes[i].expirada ? "Expirada" : "Ativa"));
        }

        scanner.close();
    }
}