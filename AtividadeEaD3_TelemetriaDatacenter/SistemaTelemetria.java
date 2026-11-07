import java.util.Scanner;

/**
 * Sistema de telemetria e monitoramento térmico contínuo para racks de servidores
 * em infraestrutura de missão crítica.
 * 
 * @author Victor Hugo
 * @version 1.0
 */
public class SistemaTelemetria {

    /** Limite térmico de segurança padrão em graus Celsius. */
    public static final double LIMITE_CRITICO = 45.0;

    /** Total de racks de servidores monitorados no Datacenter. */
    public static final int QTD_RACKS = 8;

    /**
     * Método principal (orquestrador do fluxo do programa).
     * 
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] sensores = new double[QTD_RACKS];
        boolean dadosColetados = false;
        int opcao;

        do {
            exibirMenu();
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    coletarTemperaturas(scanner, sensores);
                    dadosColetados = true;
                    System.out.println("\n-> Temperaturas registradas com sucesso!");
                    break;

                case 2:
                    if (!dadosColetados) {
                        System.out.println("\n[!] Nenhum dado coletado ainda. Execute a opção 1 primeiro.");
                    } else {
                        double media = calcularMedia(sensores);
                        System.out.printf("\n-> Temperatura Média do Datacenter: %.2f °C\n", media);
                    }
                    break;

                case 3:
                    if (!dadosColetados) {
                        System.out.println("\n[!] Nenhum dado coletado ainda. Execute a opção 1 primeiro.");
                    } else {
                        int alertas = contarAlertasCriticos(sensores, LIMITE_CRITICO);
                        System.out.printf("\n-> Total de Racks em Alerta Crítico (> %.1f °C): %d\n", LIMITE_CRITICO, alertas);
                    }
                    break;

                case 4:
                    if (!dadosColetados) {
                        System.out.println("\n[!] Nenhum dado coletado ainda. Execute a opção 1 primeiro.");
                    } else {
                        int indexMaisQuente = localizarRackMaisQuente(sensores);
                        System.out.printf("\n-> Rack mais quente: Rack %d com %.2f °C\n", 
                                          (indexMaisQuente + 1), sensores[indexMaisQuente]);
                    }
                    break;

                case 5:
                    if (!dadosColetados) {
                        System.out.println("\n[!] Colete os dados antes de gerar o relatório completo.");
                    } else {
                        exibirRelatorioCompleto(sensores);
                    }
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema de telemetria...");
                    break;

                default:
                    System.out.println("\n[!] Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Exibe o menu principal de opções no console.
     */
    public static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE TELEMETRIA DO DATACENTER ===");
        System.out.println("1 - Coletar leituras de temperatura dos 8 racks");
        System.out.println("2 - Calcular temperatura média do Datacenter");
        System.out.println("3 - Ver contagem de alertas críticos (> 45.0 °C)");
        System.out.println("4 - Localizar rack mais quente");
        System.out.println("5 - Exibir relatório completo de telemetria");
        System.out.println("0 - Sair");
    }

    /**
     * Solicita e armazena as temperaturas medidas via teclado para os 8 racks.
     * 
     * @param leitor Objeto Scanner configurado para leitura do console.
     * @param sensores Vetor de decimais onde as temperaturas serão armazenadas.
     */
    public static void coletarTemperaturas(Scanner leitor, double[] sensores) {
        System.out.println("\n--- LEITURA DOS SENSORES TÉRMICOS ---");
        for (int i = 0; i < sensores.length; i++) {
            System.out.printf("Digite a temperatura do Rack %d (°C): ", (i + 1));
            sensores[i] = leitor.nextDouble();
        }
    }

    /**
     * Calcula e retorna a temperatura média operacional da rede de racks.
     * 
     * @param sensores Vetor com as leituras de temperatura dos racks.
     * @return A temperatura média calculada em graus Celsius.
     */
    public static double calcularMedia(double[] sensores) {
        double soma = 0;
        for (double temp : sensores) {
            soma += temp;
        }
        return soma / sensores.length;
    }

    /**
     * Conta a quantidade de racks que ultrapassaram a temperatura limite de segurança.
     * 
     * @param sensores Vetor com as leituras de temperatura dos racks.
     * @param limiteMaximo Temperatura limite para considerar o estado crítico.
     * @return Total de racks operando acima da margem de segurança.
     */
    public static int contarAlertasCriticos(double[] sensores, double limiteMaximo) {
        int contador = 0;
        for (double temp : sensores) {
            if (temp > limiteMaximo) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Identifica o índice do vetor correspondente ao rack com maior temperatura.
     * 
     * @param sensores Vetor com as leituras de temperatura dos racks.
     * @return O índice (0 a 7) do rack com maior registro térmico.
     */
    public static int localizarRackMaisQuente(double[] sensores) {
        int indiceMaior = 0;
        for (int i = 1; i < sensores.length; i++) {
            if (sensores[i] > sensores[indiceMaior]) {
                indiceMaior = i;
            }
        }
        return indiceMaior;
    }

    /**
     * Exibe o relatório detalhado e formatado de todos os racks monitorados.
     * 
     * @param sensores Vetor com as leituras de temperatura dos racks.
     */
    public static void exibirRelatorioCompleto(double[] sensores) {
        System.out.println("\n========================================================");
        System.out.println("          RELATÓRIO TÉCNICO DE TELEMETRIA                ");
        System.out.println("========================================================");
        System.out.printf("%-10s | %-15s | %-15s\n", "IDENTIF.", "TEMPERATURA", "STATUS");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < sensores.length; i++) {
            String status = (sensores[i] > LIMITE_CRITICO) ? "CRÍTICO" : "NORMAL";
            System.out.printf("Rack %-5d | %-12.2f °C | %-15s\n", (i + 1), sensores[i], status);
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("Temperatura Média Geral : %.2f °C\n", calcularMedia(sensores));
        System.out.printf("Racks em Estado Crítico : %d\n", contarAlertasCriticos(sensores, LIMITE_CRITICO));
        int maisQuente = localizarRackMaisQuente(sensores);
        System.out.printf("Rack de Maior Risco     : Rack %d (%.2f °C)\n", (maisQuente + 1), sensores[maisQuente]);
        System.out.println("========================================================");
    }
}