/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author apolo
 */
public class Escalonador {

    public static void escalonarFila(int codPolitica, List<Processo> lista) {
        switch (codPolitica) {
            case 1: //FIFO

                break;
            case 2: //prioridade
                Collections.sort(lista);
                break;
            default:
                throw new AssertionError();
        }
    }

}
