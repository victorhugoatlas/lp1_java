public class AnalisadorRede {

    public static int contarRoteadoresCriticos(RoteadorCore[] rede, double limiteLatencia) {
        int criticos = 0;
        for (int i = 0; i < rede.length; i++) {
            if (rede[i] != null && rede[i].isCritico(limiteLatencia)) {
                criticos++;
            }
        }
        return criticos;
    }

    public static double somarLatenciasRecursivo(RoteadorCore[] rede, int n) {
        if (n <= 0) {
            return 0.0;
        }
        return rede[n - 1].getLatenciaMs() + somarLatenciasRecursivo(rede, n - 1);
    }
}