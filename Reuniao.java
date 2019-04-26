import java.util.LinkedList;
import java.util.List;

public class Reuniao {
    private List<String> reuniao = new LinkedList<String>();
    private LocalDate inicio;
    private LocalDate fim;
    
    public Reuniao (List<String> reuniao, LocalDate inicio, LocalDate fim) {
        this.reuniao = reuniao;
        this.inicio = inicio;
        this.fim = fim;
    }

}