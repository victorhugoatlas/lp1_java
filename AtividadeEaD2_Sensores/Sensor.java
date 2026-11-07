/**
 * Classe que representa um sensor industrial e seus atributos de monitoramento.
 * 
 * @author Victor Hugo
 * @version 1.0
 */
public class Sensor {
    /** Identificador numérico do sensor. */
    private int id;
    
    /** Setor da fábrica onde o sensor está instalado. */
    private String setor;
    
    /** Leitura de temperatura atual medida pelo sensor em graus Celsius. */
    private double temperatura;
    
    /** Status operacional do sensor ("Subresfriado", "Normal" ou "Alerta Crítico"). */
    private String status;

    /**
     * Construtor para inicialização dos dados do sensor.
     * 
     * @param id Identificador do sensor.
     * @param setor Setor de localização.
     * @param temperatura Leitura de temperatura inicial.
     */
    public Sensor(int id, String setor, double temperatura) {
        this.id = id;
        this.setor = setor;
        this.temperatura = temperatura;
        this.atualizarStatus();
    }

    /**
     * Determina e atualiza automaticamente o status operacional do sensor com base na temperatura.
     */
    public void atualizarStatus() {
        if (this.temperatura < 15.0) {
            this.status = "Subresfriado";
        } else if (this.temperatura <= 60.0) {
            this.status = "Normal";
        } else {
            this.status = "Alerta Crítico";
        }
    }

    /**
     * Obtém o identificador do sensor.
     * @return O ID do sensor.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do sensor.
     * @param id O novo ID do sensor.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o setor do sensor.
     * @return O setor cadastrado.
     */
    public String getSetor() {
        return setor;
    }

    /**
     * Define o setor do sensor.
     * @param setor O novo setor.
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * Obtém a temperatura lida pelo sensor.
     * @return A temperatura em graus Celsius.
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * Define a temperatura e reavalia automaticamente o status do sensor.
     * @param temperatura A nova temperatura.
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        this.atualizarStatus();
    }

    /**
     * Obtém o status operacional atual do sensor.
     * @return O status ("Subresfriado", "Normal" ou "Alerta Crítico").
     */
    public String getStatus() {
        return status;
    }
}