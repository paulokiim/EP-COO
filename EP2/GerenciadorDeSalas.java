import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.util.Scanner;

public class GerenciadorDeSalas {
    List<Sala> salasDisponiveis = new LinkedList<Sala>();
    Collection<Reserva> reservas = new LinkedList<Reserva>();

    public void adicionaSalaChamada(String nomeDaSala, int capacidadeMax, String descricao) {
        for (Sala sala : salasDisponiveis) {
            if (sala.getNome().equals(nomeDaSala)) {
                System.out.println ("Sala ja existente");
                return;
            }
        }
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
        Reserva nova = null;
        try {
            Sala aux = null;
            for (Sala sala : salasDisponiveis) {
                if (sala.getNome().equals(nomeDaSala)) {
                    aux = sala;
                }
            }
            if (aux != null) {
                for(Reserva reserva: reservas)
                {
                    if((reserva.getSala() == aux) && (!(fim.isBefore(reserva.getInicio())||inicio.isAfter(reserva.getFim()))))
                        throw new InvalidDataException ("Data Invalida porque ja existe uma reserva");
                }

                nova = new Reserva(aux, inicio, fim);
                reservas.add(nova);
            }
            else {
                System.out.println ("Sala nao existente no conjunto de Salas!");
                return null;
            }
        }
        catch (InvalidDataException ex) {
            System.err.println(ex.getMessage());
        }
        finally {
            return nova;
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

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        GerenciadorDeSalas gds = new GerenciadorDeSalas();

        int cont = 1;

        do {

            System.out.println("Qual opcao voce deseja?");
            System.out.println("1- Adicionar Sala Chamada\n2- Remover Sala\n3- Listar Salas\n4- Reserva Sala Chamada\n5- Cancela Reserva\n6- Lista Reservas\n7- Imprimir reserva de Sala\n0- Sair");
            cont = sc.nextInt();
            sc.nextLine();

            if (cont == 1) {
                System.out.println("Qual nome da sala que voce deseja reservar?");
                String nomeDaSala = sc.nextLine();
            
                System.out.println("Qual a capacidade maxima dessa sala?");
                int capacidade = sc.nextInt();        
                sc.nextLine();

                System.out.println("Alguma descricao para a sala?");
                String descricao = sc.nextLine();

                gds.adicionaSalaChamada(nomeDaSala, capacidade, descricao);
            }
            else if (cont == 2) {
                System.out.println ("Qual nome da sala que voce deseja remover?");
                String nomeDaSala = sc.nextLine();

                Sala nova = gds.removeSalaChamada(nomeDaSala);
                if (nova == null) {
                    System.out.println("Essa sala nao existe\n");
                }
                else {
                    System.out.printf("Sala %s removido\n\n", nomeDaSala);
                }
            }
            else if (cont == 3) {
                List<Sala> salas = gds.listaDeSalas();
                System.out.println ("Salas disponiveis:");
                for (Sala sala : salas) {
                    System.out.printf("%s ", sala.getNome());
                }
                System.out.println();
            }
            else if (cont == 4) {
                System.out.println ("Qual sala voce deseja reservar?");
                String nomeDaSala = sc.nextLine();

                System.out.println ("Diga o inicio da reserva (yyyy-MM-ddTHH:mm:ss)");
                LocalDateTime inicio = LocalDateTime.parse(sc.nextLine());

                System.out.println ("Diga o fim da reserva (yyyy-MM-ddTHH:mm:ss)");
                LocalDateTime fim = LocalDateTime.parse(sc.nextLine());

                gds.reservaSalaChamada(nomeDaSala, inicio, fim);
            }
            else if (cont == 5) {
                System.out.println("Qual o nome da sala reservada para ser cancelada?");
                String nomeDaSala = sc.nextLine();

                System.out.println ("Diga qual era o inicio da reserva (yyyy-MM-ddTHH:mm:ss)");
                LocalDateTime inicio = LocalDateTime.parse(sc.nextLine());

                System.out.println ("Diga qual era o fim da reserva (yyyy-MM-ddTHH:mm:ss)");
                LocalDateTime fim = LocalDateTime.parse(sc.nextLine());

                Reserva aux = null;

                for (Reserva reserva : gds.reservas) {
                    if (reserva.getSala().getNome().equals(nomeDaSala) && reserva.getInicio().equals(inicio) && reserva.getFim().equals(fim)) {
                        aux = reserva;
                    }
                }
                if (aux == null) {
                    System.out.println ("Sala e Horarios nao possuem reserva OU voce digitou errado!");
                }
                else {
                    System.out.println("Reserva removida com sucesso!");
                    gds.reservas.remove(aux);
                }
            }
            else if (cont == 6) {
                Collection<Reserva> reservas = gds.reservasParaSalas();
                for (Reserva reserva : reservas) {
                    System.out.println("Sala " + reserva.getSala().getNome() + ":\n");
                    System.out.print("De " + reserva.getInicio().toLocalDate().toString());
                    System.out.println(" às " + reserva.getInicio().toLocalTime().toString());
                    System.out.print("Até " + reserva.getFim().toLocalDate().toString());
                    System.out.println(" às " + reserva.getFim().toLocalTime().toString() + "\n");
                }
            }
            else if (cont == 7) {
                System.out.println ("Qual sala voce deseja consultar?");
                String resp = sc.nextLine();
                Sala aux = null;

                for (Sala sala : gds.salasDisponiveis) {
                    if (sala.getNome().equals(resp)) aux = sala;
                }

                if (aux == null) {
                    System.out.println("Voce digitou uma sala que nao existe!");
                }
                else {
                    gds.imprimeReservasDaSala(aux);
                }
            }
        } while (cont != 0);
        
        sc.close();
    }
}