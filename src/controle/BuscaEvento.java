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
import controle.CPU;

/**
 *
 * @author apolo
 */
public class BuscaEvento {
    private final CPU cpu;

    public BuscaEvento(CPU cpu) {
        this.cpu = cpu;
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
    public void executa(Processo p, int tempo){
        if (!this.cpu.isVazia()) {
            
        }
    }
}
