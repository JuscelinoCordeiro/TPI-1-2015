/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import model.Evento;
import model.Processo;
import model.TipoEvento;

/**
 *
 * @author apolo
 */
public class BuscaEvento {
    public static void criaEvento(int codEvento, Processo processo, int tempo){
        Evento evento;
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
    }
    
}
