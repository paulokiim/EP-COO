import java.time.LocalDateTime;

public class Pessoa {
    private String email;
    private List<DefinirIntervalo> intervalo = new ArrayList<DefinirIntervalo> ();

    public void setEmail (String email) {
        this.email = email;
    }
    public String getEmail () {
        return this.email;
    }

    public void adicionaIntervalo (LocalDateTime dispInicio, LocalDateTime dispFim) {
        DefinirIntervalo di = new DefinirIntervalo (dispInicio,dispFim);
        intervalo.add(di);
    }

    public LocalDateTime getIntervalo (int i) {
        return intervalo.get(i);
    }

    public ArrayLista<DefinirIntervalo> getArray () {
        return this.intervalo;
    }
}