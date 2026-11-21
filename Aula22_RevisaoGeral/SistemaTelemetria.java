public class SistemaTelemetria {
    public static void main(String[] args) {
        RoteadorCore[] rede = new RoteadorCore[3];

        rede[0] = new RoteadorCore(101, "Cisco-9000", 14.9, true);
        rede[1] = new RoteadorCore(101, "Mikrotik-CCR", 88.2, true);
        rede[2] = new RoteadorCore(101, "Huawei-NE40", 120.0, true);

        double limiteLatencia = 50.0;

        if (rede != null && rede.length > 0) {
            System.out.println("Resultado: normal até " + (int) limiteLatencia + "ms");

            for (int i = 0; i < rede.length; i++) {
                String status = rede[i].isCritico(limiteLatencia) ? "ALERTA DE ALTA LATÊNCIA" : "normal";
                System.out.println("Roteador " + i + ": " + rede[i].getModelo()
                        + " (id " + rede[i].getId() + ") - latência "
                        + rede[i].getLatenciaMs() + "ms, conexão "
                        + rede[i].isAtivo() + ", resultado: " + status);
            }

            int totalCriticos = AnalisadorRede.contarRoteadoresCriticos(rede, limiteLatencia);
            double somaLatencias = AnalisadorRede.somarLatenciasRecursivo(rede, rede.length);
            double mediaLatencias = somaLatencias / rede.length;

            System.out.println("\n--- Resumo Estatístico ---");
            System.out.println("Total de roteadores críticos: " + totalCriticos);
            System.out.println("Soma das latências: " + somaLatencias + "ms");
            System.out.printf("Média geral: %.2fms\n", mediaLatencias);
        }
    }
}