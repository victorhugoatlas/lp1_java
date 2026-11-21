public class RoteadorCore {
    private int id;
    private String modelo;
    private double latenciaMs;
    private boolean ativo;

    public RoteadorCore(int id, String modelo, double latenciaMs, boolean ativo) {
        this.id = id;
        this.modelo = modelo;
        if (latenciaMs < 0.0) {
            this.latenciaMs = 0.0;
        } else {
            this.latenciaMs = latenciaMs;
        }
        this.ativo = ativo;
    }

    public int getId() {
        return this.id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getLatenciaMs() {
        return this.latenciaMs;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public boolean isCritico(double limiteLatencia) {
        return this.ativo && this.latenciaMs > limiteLatencia;
    }
}