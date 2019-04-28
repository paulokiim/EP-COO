import java.time.LocalDateTime;

public class DefinirIntervalo { // Eh o intervalo
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public void setDataInicio (LocalDateTime inicio) {
        this.inicio = inicio;
    }
    public void setDataFim (LocalDateTime fim) {
        this.fim = fim;
    }

    public LocalDateTime getInicio () {
        return this.inicio;
    }
    public LocalDateTime getFim () {
        return this.fim;
    }
}