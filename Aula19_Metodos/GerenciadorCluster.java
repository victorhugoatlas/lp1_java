public class GerenciadorCluster {

    public static void relatorioCluster(ContainerDocker[] cluster) {
        System.out.println("=== CONTAINERS EM GARGALO (CPU > 70%) ===");
        for (ContainerDocker container : cluster) {
            if (container.isGargalo(70.0)) {
                System.out.println("ID: " + container.idContainer 
                        + " | Imagem: " + container.nomeImagem 
                        + " | CPU: " + container.usoCPU + "%" 
                        + " | RAM: " + container.usoRAMMB + " MB");
            }
        }
    }
    public static void main(String[] args) {
        ContainerDocker[] cluster = new ContainerDocker[3];
        cluster[0] = new ContainerDocker("c8f1a2", "nginx:latest", 78.5, 512.0);
        cluster[1] = new ContainerDocker("b4e9x1", "postgres:14", 45.0, 1024.0);
        cluster[2] = new ContainerDocker("a7k3m9", "node-app:v1", 85.2, 256.0);

        relatorioCluster(cluster);
    }
}