import java.time.LocalDateTime;
import java.util.List;
import java.util.LinkedList;

public class MarcadorDeReuniao {
    Map<Pessoa, DefinirIntervalo> reuniao = new LinkedHashMap<Pessoa, DefinirIntervalo>();
    public void marcarReuniaoEntre (LocalDate dataInicial, LocalDate dataFinal, LinkedList<String> listaDeParticipantes) {
        Reuniao novaReuniao = new Reuniao (listaDeParticipantes, dataInicial, dataFinal);

        
    }

    public void indicaDisponibilidadeDe (String participante, LocalDateTime inicio, LocalDateTime fim) {
        Pessoa pessoa = new Pessoa ();
        pessoa.setEmail(participante);
        pessoa.adicionaIntervalo(inicio, fim);
        reuniao.put (pessoa.getEmail(), pessoa.getIntervalo(0));

    }

    public void mostraSobreposicao () {
        
    }
}