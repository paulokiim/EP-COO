import java.time.LocalDateTime;

public class DefinirIntervalo {
    LocalDateTime inicio;
    LocalDateTime fim;

    public void setData (LocalDateTime inicio, LocalDateTime fim) {
        this.inicio = inicio;
        this.fim = fim;
    }
    public LocalDateTime getInicio () {
        return this.inicio;
    }
    public LocalDateTime getFim () {
        return this.fim;
    }
}