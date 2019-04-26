import java.time.LocalDate;

public class DefinirIntervalo {
    LocalDate inicio;
    LocalDate fim;

    public void setData (LocalDate inicio, LocalDate fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
    public LocalDate getInicio () {
        return this.inicio;
    }
    public LocalDate getFim () {
        return this.fim;
    }
}