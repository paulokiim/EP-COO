import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Participantes extends Pessoa {
    private List<DefinirIntervalo> intervalo = new ArrayList<DefinirIntervalo> ();

    public void adicionaIntervalo (LocalDate inicio, LocalDate fim) {
        DefinirIntervalo di = new DefinirIntervalo (inicio,fim);
        intervalo.add(di);
    }

    public LocalDateTime getIntervalo (int i) {
        return intervalo.get(i);
    }
}