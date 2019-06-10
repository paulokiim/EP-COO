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
            for(Reserva reserva: reservas)
			{
				if((reserva.getSala() == aux) && (!(fim.isBefore(reserva.getInicio())||inicio.isAfter(reserva.getFim())))){
                    System.out.println ("A sala já está reservada no horário de " + reserva.getInicio().toString() + " até " + reserva.getFim().toString() + "!");
                    return null;
                }
			}

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
        int cont = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getSala().equals(sala)) {
                cont++;
				System.out.println("Reserva " + cont + ":\n");
				System.out.print("De " + reserva.getInicio().toLocalDate().toString());
				System.out.println(" às " + reserva.getInicio().toLocalTime().toString());
				System.out.print("Até " + reserva.getFim().toLocalDate().toString());
				System.out.println(" às " + reserva.getFim().toLocalTime().toString() + "\n");
            }
        }
        if (cont == 0) {
            System.out.println ("Ainda nao existem reservas para essa Sala!");
        }
    }
}