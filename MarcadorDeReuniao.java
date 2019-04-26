import java.date.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.LinkedList;

public class MarcadorDeReuniao {
    public void marcarReuniaoEntre (LocalDate dataInicial, LocalDate dataFinal, LinkedList<String> listaDeParticipantes) {
        List<String> lista = new ArrayList<String> (listaDeParticipantes);
        
        for (String participante : lista) {
            java.time.LocalDate inicioPart;
            java.time.LocalDate fimPart;

            if (inicioPart.isAfter(dataInicial) && fimPart.isBefore(dataFinal)){
                Pessoa pessoa = new Participantes ();
            }

        }
    }

    public void indicaDisponibilidadeDe (String participante, LocalDateTime inicio, LocalDateTime fim) {
        
    }

    public void mostraSobreposicao () {
        
    }
}