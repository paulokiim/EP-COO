import java.time.LocalDateTime;
import java.util.LinkedList;

public class Pessoa {
    private String email;
    private List<DefinirIntervalo> intervalo = new LinkedList<DefinirIntervalo> ();
    int cont = -1;

    public void setEmail (String email) {
        this.email = email;
    }
    public String getEmail () {
        return this.email;
    }

    public void adicionaIntervalo (LocalDateTime dispInicio, LocalDateTime dispFim) {
        DefinirIntervalo di = new DefinirIntervalo (dispInicio,dispFim);
        intervalo.add(di);
        cont++;
    }

    public LocalDateTime getIntervalo (int i) {
        return intervalo.get(i);
    }

    public ArrayLista<DefinirIntervalo> getArray () {
        return this.intervalo;
    }
}