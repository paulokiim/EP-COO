import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collection;

public class MarcadorDeReuniao {
    List<Pessoa> pessoas = new LinkedList<>();
    List<Intervalo> reuniao = new LinkedList<>();
    LocalDate inicioReuniao;
    LocalDate fimReuniao;
    
    Scanner sc = new Scanner (System.in);

    public void marcarReuniaoEntre (LocalDate dataInicial, LocalDate dataFinal, Collection<String> listaDeParticipantes) {
        for (String participante : listaDeParticipantes) {
            String resp = "S";
            int i = 1;
            Pessoa novo = new Pessoa(participante);
            pessoas.add(novo);
            System.out.println (participante+", declare suas disponibilidades");
            while (resp.equals("S") || resp.equals("s")){
                System.out.println("Inicio do intervalo "+i+" (yyyy-MM-ddTHH:mm:ss): ");
                LocalDateTime inicio = LocalDateTime.parse(sc.nextLine());

                System.out.println("Fim do intervalo "+i+" (yyyy-MM-ddTHH:mm:ss): ");
                LocalDateTime fim = LocalDateTime.parse(sc.nextLine());

                if(inicio.isBefore(fim) && inicio.isAfter(dataInicial.atStartOfDay()) && fim.isBefore(dataFinal.atTime(23, 59, 59))){
                    this.indicaDisponibilidadeDe(participante, inicio, fim);
                }
                else{
                    System.out.println("Datas inválidas.");
                }

                System.out.println ("Tem mais horario disponivel? (S/N)");
                resp = sc.nextLine();
                if (resp.equals("S") || resp.equals("s")) {
                    System.out.println ("Entao, continue inserindo: ");
                    i++;
                }
            }
        }
    }

    public void indicaDisponibilidadeDe (String participante, LocalDateTime inicio, LocalDateTime fim) {
        Intervalo i = new Intervalo(inicio, fim);
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getEmail().equals(participante)) {
                pessoa.addDisponibilidade(i);
                break;
            }
        }

    }

    public void mostraSobreposicao () {
        imprimeDisponibilidades(this.pessoas);

        criaInterseccao(this.inicioReuniao.atStartOfDay(),this.fimReuniao.atTime(23, 59) , 0);
        if (reuniao.isEmpty()) {
            System.out.println ("============Nao existem reunioes possiveis!============");
        }
        else {
            System.out.println ("A possiveis reunioes sao: ");
            int n = 1;
            
            for (Intervalo i : reuniao) {
                System.out.print ("Reuniao " + n + ": " + i.getInicio().toLocalDate().toString() + " " + i.getInicio().toLocalTime().toString()); 
                System.out.println (" ate " + i.getFim().toLocalDate().toString() + " " + i.getFim().toLocalTime().toString());
                n++;
            }
        }
        
    }
    
    public void criaInterseccao (LocalDateTime inicial, LocalDateTime finale, int i) {
        LocalDateTime inicio = inicial;
        LocalDateTime fim = finale;

        Pessoa participante = pessoas.get(i);

        for (Intervalo inter : participante.getAllDisp()) {
            if (inter.getInicio().isBefore(finale) && inter.getFim().isAfter(inicial)) {
                if (inter.getInicio().isAfter(inicial)) {
                    inicial = inter.getInicio();
                }
                if (inter.getFim().isBefore(finale)) {
                    finale = inter.getFim();
                }
                if (i == (pessoas.size() - 1)) {
                    Intervalo ultimo = new Intervalo(inicial, finale);
                    reuniao.add(ultimo);
                }
                else {
                    criaInterseccao(inicial,finale, i+1);
                }
            }
            inicial = inicio;
            finale = fim;
        }
    }

    public void imprimeDisponibilidades (List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            System.out.println (pessoa.getEmail() + " possui esses horarios: ");
            int n = 1;
            for (Intervalo i : pessoa.getAllDisp()) {
                System.out.print ("Horario disponivel " + n + ": " + i.getInicio().toLocalDate().toString() + " " + i.getInicio().toLocalTime().toString()); 
                System.out.println (" ate " + i.getFim().toLocalDate().toString() + " " + i.getFim().toLocalTime().toString());
                n++;
            }
        }
        System.out.printf("\n");  
    }

    public static void main (String args[]) {
        System.out.println ("----- EP - COO By: Pedrin&Paulin -----");
        Scanner sc = new Scanner (System.in);
        MarcadorDeReuniao mdr = new MarcadorDeReuniao();

        List<String> participantes = new LinkedList<String>();

        String resp = "S";
        String participante;
        int i = 1;
        while (resp.equals("S") || resp.equals("s")) {
            System.out.println("Insira o " + i + " participante: ");
            participante = sc.nextLine(); 
            participantes.add (participante); 

            System.out.println("Deseja inserir mais participantes? (S/N)");
            resp = sc.nextLine();
            if (resp.equals("S") || resp.equals("s")) {
                System.out.println ("Entao, continue inserindo: ");
                i++;
            }
        }

        System.out.println("Organizador, indique qual a data inicial da reunião: (yyyy-MM-dd)");
        LocalDate inicioDaReuniao = LocalDate.parse(sc.nextLine());
        mdr.inicioReuniao = inicioDaReuniao;

        System.out.println("Organizador, indique qual a data final da reunião: (yyyy-MM-dd)");
        LocalDate fimDaReuniao = LocalDate.parse(sc.nextLine());
        mdr.fimReuniao = fimDaReuniao;

        mdr.marcarReuniaoEntre(inicioDaReuniao, fimDaReuniao, participantes);
        mdr.mostraSobreposicao();

        sc.close();
    } 
}