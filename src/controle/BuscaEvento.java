/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.LinkedList;
import model.Evento;
import model.Processo;
import model.TipoEvento;
import java.util.List;
import model.Escalonador;
import model.Estatistica;

/**
 *
 * @author apolo
 */
public class BuscaEvento {

    private final CPU cpu;
    private int contador;
    //fila de eventos
    List<Evento> filaDeEventos = new LinkedList<>();
    private Escalonador escalonador;

    public BuscaEvento() {
        this.cpu = new CPU();
        this.contador = 0;
        this.escalonador = new Escalonador();
    }

    public int getContador() {
        return contador;
    }

    public void incContador() {
        this.contador++;
    }

    public Escalonador getEscalonador() {
        return escalonador;
    }
    
    

    public Evento criaEvento(int codEvento, Processo processo, int tempo) {
        Evento evento = null;
        switch (codEvento) {
            case 1:
                evento = new Evento(TipoEvento.termino.getTipo(), processo, tempo, TipoEvento.termino.getPrioridade());
                break;
            case 2:
                evento = new Evento(TipoEvento.chegada.getTipo(), processo, tempo, TipoEvento.chegada.getPrioridade());
                break;
            case 3:
                evento = new Evento(TipoEvento.escalonamento.getTipo(), processo, tempo, TipoEvento.escalonamento.getPrioridade());
                break;
            case 4:
                evento = new Evento(TipoEvento.execucao.getTipo(), processo, tempo, TipoEvento.execucao.getPrioridade());
                break;
            default:
//                throw new AssertionError();
                System.out.println("Não foi possivel criar o evento.");
        }
        return evento;
    }

    /*
     1-pega processo na fila do escalonador 
     2 - cria evento SCHED_EVT em "tempo"
     */
    public void chega(Processo p, int tempo, LinkedList filaDeEventos, LinkedList filaDoEscalonador) {
        Evento evt = criaEvento(3, p, tempo);
        filaDeEventos.add(evt);
        filaDoEscalonador.add(p);
    }

    /*
     1-retira processo da CPU
     2-salva os dados estatisticos
     */
    public void termina(Processo p, int tempo) {
        boolean terminado;
        this.cpu.liberarCPU();
    }

    /*
     1-Se cpu ocupada por processo P'
     - tira P' da CPU
     - remove da linha de eventos TERM_EVT(P')
     - coloca em P' quanto tempo falta para ele terminar
     - coloca P' na fila do escalonador
     2-poe P na cpu
     3-cria evento TERM_EVT(P, T + tempo que resta para p terminar)
     */
    public void executa(Processo p, int tempo) {
        if (!this.cpu.isVazia()) {
            Processo p2 = this.cpu.liberarCPU();
            boolean achouEvento = false;
            int tempoDeExecucao = 0;

            for (int i = 0; i < filaDeEventos.size(); i++) {
                if (filaDeEventos.get(i).getProcesso().equals(p2) && filaDeEventos.get(i).getTipo().equals(TipoEvento.termino.getTipo())) {
                    filaDeEventos.remove(i);
                    achouEvento = true;
                    tempoDeExecucao = Estatistica.calculaTempoExecucaoProcesso(p2);

                    if (!(filaDeEventos.get(i).getProcesso().getDuracao() == tempoDeExecucao)) {
                        p2.setDuracao(p2.getDuracao() - tempoDeExecucao);
                        this.escalonador.getFilaDoEscalonador().add(p2);
                    }
                }
                if (achouEvento) {
                    break;
                }
            }
        }
        Evento ex = this.criaEvento(1, p, (p.getDuracao()+this.getContador()));
        this.filaDeEventos.add(ex);        
    }

}
