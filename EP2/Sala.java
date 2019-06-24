public class Sala {
    private String nome;
    private String local;
    private String obs;
    private int capacidade;

    Sala (String nome, String local, String obs, int capacidade) {
        this.nome = nome;
        this.local = local;
        this.obs = obs;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }
    public String getLocal() {
        return local;
    }
    public String getObs() {
        return obs;
    }
    public int getCapacidade() {
        return capacidade;
    }
}