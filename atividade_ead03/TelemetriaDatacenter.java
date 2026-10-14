import java.util.Scanner;

public class TelemetriaDatacenter {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double[] sensores = new double[8];
        boolean dadosColetados = false;
        int opcao = 0;

        do {
            exibirMenu();
            if (leitor.hasNextInt()) {
                opcao = leitor.nextInt();
                
                switch (opcao) {
                    case 1:
                        coletarTemperaturas(leitor, sensores);
                        dadosColetados = true;
                        break;
                    case 2:
                        if (!dadosColetados) {
                            System.out.println("Erro: Colete as temperaturas primeiro (Opcao 1).");
                        } else {
                            double media = calcularMedia(sensores);
                            System.out.printf("Temperatura media dos racks: %.2f °C%n", media);
                        }
                        break;
                    case 3:
                        if (!dadosColetados) {
                            System.out.println("Erro: Colete as temperaturas primeiro (Opcao 1).");
                        } else {
                            System.out.print("Informe a temperatura limite critica (°C): ");
                            double limite = leitor.nextDouble();
                            int qtdAlertas = contarAlertasCriticos(sensores, limite);
                            System.out.println("Quantidade de racks em estado critico: " + qtdAlertas);
                        }
                        break;
                    case 4:
                        if (!dadosColetados) {
                            System.out.println("Erro: Colete as temperaturas primeiro (Opcao 1).");
                        } else {
                            int indiceMaisQuente = localizarRackMaisQuente(sensores);
                            System.out.printf("Rack mais quente: Rack %d com %.2f °C%n", 
                                    indiceMaisQuente, sensores[indiceMaisQuente]);
                        }
                        break;
                    case 5:
                        System.out.println("Encerrando o sistema de telemetria...");
                        break;
                    default:
                        System.out.println("Opcao invalida! Tente novamente.");
                }
            } else {
                System.out.println("Entrada invalida! Digite um numero.");
                leitor.next();
            }
            System.out.println();
        } while (opcao != 5);

        leitor.close();
    }

    /**
     * Exibe no console o menu principal de opcoes do sistema de telemetria.
     */
    public static void exibirMenu() {
        System.out.println("=== PAINEL DE MONITORAMENTO DE RACKS ===");
        System.out.println("1. Coletar temperaturas dos sensores");
        System.out.println("2. Exibir temperatura media dos racks");
        System.out.println("3. Contar alertas de temperatura critica");
        System.out.println("4. Localizar rack mais quente");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opcao: ");
    }

    /**
     * Le o teclado e armazena no vetor as temperaturas coletadas dos 8 racks.
     *
     * @param leitor Objeto Scanner para leitura da entrada do usuario.
     * @param sensores Vetor do tipo double onde serao salvas as temperaturas.
     */
    public static void coletarTemperaturas(Scanner leitor, double[] sensores) {
        System.out.println("--- Coleta de Temperaturas ---");
        for (int i = 0; i < sensores.length; i++) {
            System.out.print("Digite a temperatura do Rack " + i + " (°C): ");
            sensores[i] = leitor.nextDouble();
        }
        System.out.println("Temperaturas registradas com sucesso!");
    }

    /**
     * Calcula a media aritmetica de todas as temperaturas contidas no vetor.
     *
     * @param sensores Vetor double com as temperaturas dos racks.
     * @return A media das temperaturas calculadas.
     */
    public static double calcularMedia(double[] sensores) {
        double soma = 0.0;
        for (double temp : sensores) {
            soma += temp;
        }
        return soma / sensores.length;
    }

    /**
     * Conta quantos rackss registraram temperatura  maior que o limite fornecido.
     *
     * @param sensores Vetor contendo os dados de temperatura dos racks.
     * @param limiteMaximo O valor limite de temperatura considerado seguro.
     * @return O número de racks que ultrapassaram a margem de segurança.
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
     * Localiza qual rack apresentou a maior temperatura registrada.
     *
     * @param sensores Vetor com as temperaturas de todos os racks.
     * @return O índice do vetor correspondente ao rack mais quente.
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
}