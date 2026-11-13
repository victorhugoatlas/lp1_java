public class TestaServidor {
    public static void main(String[] args) {
        ArquivoCloud[] arquivos = new ArquivoCloud[3];

        arquivos[0] = new ArquivoCloud("relatorio.pdf", 14.5, true);
        arquivos[1] = new ArquivoCloud("backup_banco.sql", 250.0, false);
        arquivos[2] = new ArquivoCloud("foto_perfil.png", 2.3, false);

        System.out.println("Arquivos pesados ou criptografados:");
        for (int i = 0; i < arquivos.length; i++) {
            if (arquivos[i].isArquivoPesado() || arquivos[i].isCriptografado()) {
                System.out.println("- " + arquivos[i].getNomeArquivo());
            }
        }
    }
}