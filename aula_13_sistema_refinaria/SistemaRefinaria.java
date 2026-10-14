import java.util.Scanner;

public class SistemaRefinaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        
        double pressao = -1;
        boolean pressaoValidada = false;
        double mediaTemperatura = -1;
        boolean varreduraRealizada = false;

        while (opcao != 0) {
            System.out.println("\n--- OPÇÕES ---");
            System.out.println("1 - Módulo 1: Validação de Pressão de Tanque");
            System.out.println("2 - Módulo 2: Varredura de Malha Térmica 2D");
            System.out.println("3 - Módulo 3: Relatório do Sistema e Decisão Global");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a pressão inicial do tanque (PSI): ");
                    pressao = scanner.nextDouble();

                    while (pressao < 10.0 || pressao > 60.0) {
                        System.out.print("Pressão inválida. Digite novamente (10.0 a 60.0 PSI): ");
                        pressao = scanner.nextDouble();
                    }

                    pressaoValidada = true;
                    System.out.printf("Pressão Operacional de %.2f PSI registrada com sucesso!\n", pressao);
                    break;

                case 2:
                    double somaTemperaturas = 0;
                    int contadorValidos = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            System.out.print("Digite a temperatura do Sensor [" + i + "," + j + "] (°C): ");
                            double temp = scanner.nextDouble();

                            if (temp < 0.0) {
                                System.out.println("Sensor [" + i + "," + j + "]: Ruído detectado! Ignorando...");
                                continue;
                            }

                            if (temp > 90.0) {
                                System.out.println("ALERTA VERMELHO no Sensor [" + i + "," + j + "] (" + temp + " °C)! Emergência ativada!");
                                break;
                            }

                            somaTemperaturas += temp;
                            contadorValidos++;
                        }
                    }

                    if (contadorValidos > 0) {
                        mediaTemperatura = somaTemperaturas / contadorValidos;
                        varreduraRealizada = true;
                        System.out.printf("Média das temperaturas válidas: %.1f °C\n", mediaTemperatura);
                    } else {
                        System.out.println("Nenhuma leitura válida de temperatura foi registrada.");
                    }
                    break;

                case 3:
                    if (!pressaoValidada || !varreduraRealizada) {
                        System.out.println("Dados insuficientes! Execute o Módulo 1 e o Módulo 2 antes do relatório.");
                    } else if (pressaoValidada && mediaTemperatura <= 45.0) {
                        System.out.println("STATUS GLOBAL: Operação em Nível Verde (Estável)");
                    } else if (mediaTemperatura >= 45.1 && mediaTemperatura <= 75.0) {
                        System.out.println("STATUS GLOBAL: Operação em Nível Amarelo (Atenção ao Resfriamento)");
                    } else {
                        System.out.println("STATUS GLOBAL: Operação em Nível Vermelho (Risco de Parada Térmica)");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}