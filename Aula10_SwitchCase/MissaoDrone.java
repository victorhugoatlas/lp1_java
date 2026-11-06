import java.util.Scanner;

public class MissaoDrone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o modo de missão (M - Mapeamento, R - Resgate, E - Emergência): ");
        char modo = scanner.next().charAt(0);

        switch (modo) {
            case 'M':
            case 'm':
                System.out.print("Digite a porcentagem de carga da bateria: ");
                double bateria = scanner.nextDouble();
                if (bateria >= 30.0) {
                    System.out.println("Missão de Mapeamento AUTORIZADA. Bateria em nível seguro.");
                } else {
                    System.out.println("Missão ABORTADA: Bateria insuficiente para retornar em segurança.");
                }
                break;

            case 'R':
            case 'r':
                System.out.print("Digite a velocidade do vento em km/h: ");
                double vento = scanner.nextDouble();
                if (vento <= 35.0) {
                    System.out.println("Missão de Resgate AUTORIZADA. Vento em nível seguro.");
                } else {
                    System.out.println("Missão ABORTADA: Vento acima do limite estrutural do drone!");
                }
                break;

            case 'E':
            case 'e':
                System.out.println("PROCEDIMENTO RTH (Return-To-Home) ATIVADO: Retornando imediatamente à base!");
                break;

            default:
                System.out.println("Erro: Modo de missão não reconhecido.");
                break;
        }

        scanner.close();
    }
}