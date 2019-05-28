import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String email;
    private List<Intervalo> disponibilidade = new ArrayList<Intervalo>();
    
    public void addDisponibilidade (Intervalo i) {
        disponibilidade.add(i);
    }

    public Intervalo getDisponibilidade (int i) {
        return disponibilidade.get(i);
    }

    public List<Intervalo> getAllDisp () {
        return this.disponibilidade;
    }

    public Pessoa (String email) {
        this.email = email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getEmail () {
        return this.email;
    }
}