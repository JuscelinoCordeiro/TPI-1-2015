/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import model.Processo;

/**
 *
 * @author jfilho
 * @date 16/05/2015
 */
public class CPU {

    private Processo processo;
    private boolean vazia;

    public CPU() {
        this.processo = null;
        this.vazia = true;
    }

    public Processo getProcesso() {
        return processo;
    }

    public boolean isVazia() {
        return vazia;
    }

    public void alocarCPU(Processo processo) {
        this.processo = processo;
        this.vazia = false;
    }

    public Processo liberarCPU() {
        Processo p = this.processo;
        this.processo = null;
        vazia = true;
        return p;
    }

}
