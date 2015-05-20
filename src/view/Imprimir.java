/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import model.Processo;

/**
 *
 * @author apolo
 */
public class Imprimir {

    public static void processo(Processo p) {
        System.out.println("\nDados do processo: \n");
        System.out.println("ID: " + p.getId());
        System.out.println("Tempo de chegada: " + p.getTmpChegada());
        System.out.println("Duração: " + p.getDuracao());
        System.out.println("Prioridade: " + p.getPrioridade());
    }

    public static void fila(List fila) {
        for (int i = 0; i < fila.size(); i++) {
            processo((Processo) fila.get(i));
        }
    }
}
