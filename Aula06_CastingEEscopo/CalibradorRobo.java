public class CalibradorRobo {
    public static void main(String[] args) {
        double leituraSensor = 142.89;
        int passosMotor = (int) leituraSensor;

        System.out.println("Leitura do Sensor (double): " + leituraSensor);
        System.out.println("Passos do Motor (int): " + passosMotor);
    }
}