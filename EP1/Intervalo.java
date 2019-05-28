import java.time.LocalDateTime;

public class Intervalo {
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Intervalo (LocalDateTime inicio, LocalDateTime fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public void setInicio (LocalDateTime inicio) {
        this.inicio = inicio;
    }
    public void setFim (LocalDateTime fim) {
        this.fim = fim;
    }

    public LocalDateTime getInicio () {
        return this.inicio;
    }
    public LocalDateTime getFim () {
        return this.fim;
    }
}