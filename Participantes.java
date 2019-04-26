import java.time.LocalDate;
import java.util.ArrayList;

public class Participantes extends Pessoa {
    private List<DefinirIntervalo> intervalo = new ArrayList<DefinirIntervalo> ();

    public void adicionaIntervalo (LocalDate inicio, LocalDate fim) {
        DefinirIntervalo di = new DefinirIntervalo (inicio,fim);
        intervalo.add(i);
    }

    public getIntervalo (int i) {
        return intervalo.get(indice);
    }
}