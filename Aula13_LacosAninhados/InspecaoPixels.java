import java.util.Scanner;

public class InspecaoPixels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pixelsBons = 0;
        boolean pecaBoa = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int valor;
                while (true) {
                    System.out.print("Pixel [" + i + "][" + j + "]: ");
                    valor = scanner.nextInt();
                    if (valor >= 0 && valor <= 256) {
                        break;
                    }
                    System.out.println("valor fora do intervalo: 0 a 256");
                }

                if (valor == 256) {
                    continue;
                }

                if (valor >= 100 && valor <= 200) {
                    pixelsBons++;
                    if (pixelsBons >= 10) {
                        pecaBoa = true;
                        break;
                    }
                }
            }
            if (pecaBoa) {
                break;
            }
        }

        if (pecaBoa) {
            System.out.println("Peça APROVADA! Atingiu 10 pixels válidos.");
        } else {
            System.out.println("Peça REPROVADA!");
        }

        scanner.close();
    }
}