/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author apolo
 */
public enum TipoEvento {
    chegada("CHG_EVT", 2), termino("TERM_EVT", 1), escalonamento("SCHED_EVT", 3), execucao("EXEC_EVT", 4);
    
    private final String tipo;
    private final int prioridade;

    private TipoEvento(String tipo, int prioridade) {
        this.tipo = tipo;
        this.prioridade = prioridade;
    }  

    public String getTipo() {
        return tipo;
    }

    public int getPrioridade() {
        return prioridade;
    }
    
    
}
