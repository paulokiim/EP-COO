import java.time.LocalDateTime;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class MarcadorDeReuniao {
    List<Pessoa> participantes = new LinkedList();
    Scanner sc = new Scanner (System.in);
    //Na main, vamos inicializar a quantidade de participantes
    public void marcarReuniaoEntre (LocalDate dataInicial, LocalDate dataFinal, LinkedList<String> listaDeParticipantes) {
        //Reuniao novaReuniao = new Reuniao (listaDeParticipantes, dataInicial, dataFinal);
        for (String pessoa : listaDeParticipantes) {
            this.indicaDisponibilidadeDe(pessoa, dataInicial, dataFinal);
        }
        
    }

    public void indicaDisponibilidadeDe (String participante, LocalDateTime inicio, LocalDateTime fim) {
        /*Pessoa pessoa = new Pessoa ();
        pessoa.setEmail(participante);
        pessoa.adicionaIntervalo(inicio, fim);
        reuniao.put (pessoa.getEmail(), pessoa.getIntervalo(pessoa.cont));
        */
        Pessoa aux = NULL;
        for (Pessoa pessoa : participantes) {
            if (pessoa.getEmail().equals(participante)) {
                aux = pessoa;
                break;
            }
        }
        if (aux != NULL) {
            aux.adicionaIntervalo(inicio, fim);
        }
    }

    public void mostraSobreposicao () {
        
    }
}