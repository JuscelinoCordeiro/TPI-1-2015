/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author apolo
 */
public class Processo implements Comparable<Processo> {

    private int id;
    private int tmpChegada;
    private int duracao;
    private int prioridade;
    private List<Interrupcao> interrupcoes;

    public Processo() {
        this.interrupcoes = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTmpChegada() {
        return tmpChegada;
    }

    public void setTmpChegada(int tmpChegada) {
        this.tmpChegada = tmpChegada;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public int compareTo(Processo outroProcesso) {
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (this.tmpChegada == outroProcesso.getTmpChegada() && this.prioridade < outroProcesso.prioridade) {
            return -1;
        }
        if (this.tmpChegada == outroProcesso.getTmpChegada() && this.prioridade > outroProcesso.prioridade) {
            return 1;
        }
        return 0;
    }
    
    

}
