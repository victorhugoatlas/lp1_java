public class ArquivoCloud {
    private String nomeArquivo;
    private double tamanhoMB;
    private boolean criptografado;

    public ArquivoCloud(String nomeArquivo, double tamanhoMB, boolean criptografado) {
        this.nomeArquivo = nomeArquivo;
        if (tamanhoMB < 0.0) {
            this.tamanhoMB = 0.0;
        } else {
            this.tamanhoMB = tamanhoMB;
        }
        this.criptografado = criptografado;
    }

    public String getNomeArquivo() {
        return this.nomeArquivo;
    }

    public double getTamanhoMB() {
        return this.tamanhoMB;
    }

    public boolean isCriptografado() {
        return this.criptografado;
    }

    public boolean isArquivoPesado() {
        return this.tamanhoMB > 100.0;
    }
}