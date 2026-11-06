import java.util.Scanner;

public class PainelRefinaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pressao = -1;
        boolean pressaoValidada = false;
        double mediaTemperatura = 0;
        boolean varreduraRealizada = false;
        int opcao;

        do {
            System.out.println("\n=== PAINEL DE CONTROLE DA REFINARIA ===");
            System.out.println("1 - Módulo 1: Validação de Pressão de Tanque");
            System.out.println("2 - Módulo 2: Varredura de Malha Térmica 2D");
            System.out.println("3 - Módulo 3: Relatório do Sistema e Decisão Global");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite a pressão inicial do tanque (PSI): ");
                pressao = scanner.nextDouble();

                while (pressao < 10.0 || pressao > 60.0) {
                    System.out.print("Pressão fora da faixa operacional segura (10.0 a 60.0). Digite novamente: ");
                    pressao = scanner.nextDouble();
                }

                pressaoValidada = true;
                System.out.println("Pressão Operacional de " + pressao + " PSI registrada com sucesso!");

            } else if (opcao == 2) {
                double somaTemp = 0;
                int contValidos = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print("Temperatura Sensor [" + i + "][" + j + "]: ");
                        double temp = scanner.nextDouble();

                        if (temp < 0.0) {
                            System.out.println("Sensor [" + i + "," + j + "]: Ruído detectado! Ignorando...");
                            continue;
                        }

                        if (temp > 90.0) {
                            System.out.println("ALERTA VERMELHO no Sensor [" + i + "," + j + "] (" + temp + "°C)! Emergência ativada!");
                            break;
                        }

                        somaTemp += temp;
                        contValidos++;
                    }
                }

                if (contValidos > 0) {
                    mediaTemperatura = somaTemp / contValidos;
                    varreduraRealizada = true;
                    System.out.println("Média das temperaturas válidas: " + mediaTemperatura + "°C");
                } else {
                    System.out.println("Nenhuma leitura válida realizada.");
                }

            } else if (opcao == 3) {
                if (!pressaoValidada || !varreduraRealizada) {
                    System.out.println("Realize a validação da pressão (Módulo 1) e a varredura (Módulo 2) antes do relatório.");
                } else {
                    if (pressaoValidada && mediaTemperatura <= 45.0) {
                        System.out.println("STATUS GLOBAL: Operação em Nível Verde (Estável)");
                    } else if (mediaTemperatura >= 45.1 && mediaTemperatura <= 75.0) {
                        System.out.println("STATUS GLOBAL: Operação em Nível Amarelo (Atenção ao Resfriamento)");
                    } else {
                        System.out.println("STATUS GLOBAL: Operação em Nível Vermelho (Risco de Parada Térmica)");
                    }
                }

            } else if (opcao != 0) {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}