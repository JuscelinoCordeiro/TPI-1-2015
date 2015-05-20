/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author juscelino
 */
public class Escalonador {

    private List<Processo> filaDoEscalonador = new LinkedList<>();

    public List<Processo> getFilaDoEscalonador() {
        return filaDoEscalonador;
    }

    public void setFilaDoEscalonador(List<Processo> filaDoEscalonador) {
        this.filaDoEscalonador = filaDoEscalonador;
    }

    public static void escalonarFilaPorPrioridade(int codPolitica, List<Processo> lista) {
        switch (codPolitica) {
            case 1: //FIFO

                break;
            case 2: //ordem de chegada e prioridade
                Collections.sort(lista);
                break;
            default:
                throw new AssertionError();
        }
    }

}
