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
public class Evento {
    private String tipo;
    private Processo processo;
    private int tempo;
    private int prioridade;

    public Evento(String tipo, Processo processo, int tempo, int prioridade) {
        this.tipo = tipo;
        this.processo = processo;
        this.tempo = tempo;
        this.prioridade = prioridade;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    
    
    
}
