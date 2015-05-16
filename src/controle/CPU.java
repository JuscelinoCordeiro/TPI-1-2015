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
 */
public class CPU {

    private Processo processo;

    public CPU() {
        this.processo = null;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void alocarCPU(Processo processo) {
        this.processo = processo;
    }

    public boolean liberarCPU() {
        processo = null;
        return false;
    }

}
