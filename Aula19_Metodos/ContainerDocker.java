public class ContainerDocker {
    String idContainer;
    String nomeImagem;
    double usoCPU;
    double usoRAMMB;

    public ContainerDocker(String idContainer, String nomeImagem, double usoCPU, double usoRAMMB) {
        this.idContainer = idContainer;
        this.nomeImagem = nomeImagem;
        this.usoCPU = usoCPU;
        this.usoRAMMB = usoRAMMB;
    }
    public boolean isGargalo(double limiteCPU) {
        return this.usoCPU > limiteCPU;
    }
}