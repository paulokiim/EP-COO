import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;

public class GerenciadorDeSalas {
    List<Sala> salasDisponiveis = new LinkedList<Sala>();
    Collection<Reserva> reservas = new LinkedList<Reserva>();

    public void adicionaSalaChamada(String nomeDaSala, int capacidadeMax, String descricao) {
        Sala nova = new Sala(nomeDaSala, descricao , descricao, capacidadeMax); //Arrumar o "Local"
        salasDisponiveis.add(nova);
    }

    public Sala removeSalaChamada(String nomeDaSala) {
        Sala aux = null;
        for (Sala sala : salasDisponiveis) {
            if (sala.getNome().equals(nomeDaSala)) {
                aux = sala;
                salasDisponiveis.remove(sala);
            }
        }
        return aux;
    }

    public List<Sala> listaDeSalas() {
        return salasDisponiveis;
    }

    public void adicionaSala(Sala nomeDaSala) {
        for (Sala sala : salasDisponiveis) {
            if (nomeDaSala.getNome().equals(sala.getNome())) {
                System.out.println("Essa Sala ja existe!");
                return;
            }
        }
        salasDisponiveis.add(nomeDaSala);
    }

    public Reserva reservaSalaChamada(String nomeDaSala, LocalDateTime inicio, LocalDateTime fim) {
        Sala aux = null;
        for (Sala sala : salasDisponiveis) {
            if (sala.getNome().equals(nomeDaSala)) {
                aux = sala;
            }
        }
        if (aux != null) {
            Reserva nova = new Reserva(aux, inicio, fim);
            reservas.add(nova);
            return nova;
        }
        else {
            System.out.println ("Sala nao existente no conjunto de Salas!");
            return null;
        }

    }
    public void cancelaReserva(Reserva reserva) {
        Iterator<Reserva> it = reservas.iterator();

        while (it.hasNext()) {
            if (it.next() == reserva) {
                it.remove();
                return;
            }
        }

        System.out.println ("Nao existe essa reserva!");
    }

    public Collection<Reserva> reservasParaSalas() {
        return reservas;
    }

    public void imprimeReservasDaSala(Sala sala) {

    }
}