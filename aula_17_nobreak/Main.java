public import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ModuloBateria[] modulos = new ModuloBateria[3];

        for (int i = 0; i < modulos.length; i++) {
            modulos[i] = new ModuloBateria();
            modulos[i].id = scanner.nextInt();
            modulos[i].tensao = scanner.nextDouble();
            modulos[i].temperatura = scanner.nextDouble();

            if (modulos[i].tensao < 11.5 || modulos[i].temperatura > 50.0) {
                modulos[i].emAlerta = true;
            } else {
                modulos[i].emAlerta = false;
            }
        }

        double somaTensao = 0;
        int totalAlertas = 0;

        for (ModuloBateria m : modulos) {
            System.out.printf("ID: %d | Tensão: %.1fV | Temp: %.1f°C | Alerta: %b%n",
                    m.id, m.tensao, m.temperatura, m.emAlerta);

            somaTensao += m.tensao;
            if (m.emAlerta) {
                totalAlertas++;
            }
        }

        System.out.printf("Média de tensão: %.2fV%n", somaTensao / modulos.length);
        System.out.println("Total de módulos em alerta: " + totalAlertas);

        scanner.close();
    }
} {   
}