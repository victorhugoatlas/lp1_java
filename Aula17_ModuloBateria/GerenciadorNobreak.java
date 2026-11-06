import java.util.Scanner;

public class GerenciadorNobreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ModuloBateria[] modulos = new ModuloBateria[3];
        double somaTensao = 0;
        int totalAlertas = 0;

        for (int i = 0; i < modulos.length; i++) {
            modulos[i] = new ModuloBateria();

            System.out.println("--- Módulo " + (i + 1) + " ---");
            System.out.print("ID: ");
            modulos[i].id = scanner.nextInt();

            System.out.print("Tensão (V): ");
            modulos[i].tensao = scanner.nextDouble();

            System.out.print("Temperatura (°C): ");
            modulos[i].temperatura = scanner.nextDouble();

            if (modulos[i].tensao < 11.5 || modulos[i].temperatura > 50.0) {
                modulos[i].emAlerta = true;
            } else {
                modulos[i].emAlerta = false;
            }
        }

        System.out.println("\n=== RELATÓRIO DO BANCO DE BATERIAS ===");
        for (int i = 0; i < modulos.length; i++) {
            System.out.println("ID: " + modulos[i].id + 
                               " | Tensão: " + modulos[i].tensao + "V" + 
                               " | Temp: " + modulos[i].temperatura + "°C" + 
                               " | Alerta: " + (modulos[i].emAlerta ? "SIM" : "NÃO"));

            somaTensao += modulos[i].tensao;
            if (modulos[i].emAlerta) {
                totalAlertas++;
            }
        }

        double mediaTensao = somaTensao / modulos.length;
        System.out.println("\nMédia de Tensão: " + mediaTensao + "V");
        System.out.println("Total em Alerta: " + totalAlertas);

        scanner.close();
    }
}