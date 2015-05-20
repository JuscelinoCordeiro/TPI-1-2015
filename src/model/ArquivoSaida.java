/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author juscelino
 */
public class ArquivoSaida {

    private FileWriter arquivo;
    private boolean arquivoAberto;

    public ArquivoSaida() {
        this.arquivoAberto = false;
    }

    public boolean abrir(String nomeArquivo) {
        try {
            this.arquivo = new FileWriter(nomeArquivo);
            arquivoAberto = true;
            return arquivoAberto;
        } catch (IOException e) {
            return arquivoAberto;
        }
    }

    public boolean fechar(FileWriter arq) {
        try {
            arq.close();
            arquivoAberto = false;
            return arquivoAberto;
        } catch (IOException e) {
            return arquivoAberto;
        }
    }

    public boolean verificarArquivoAberto() {
        return arquivoAberto;
    }

    public FileWriter getArquivo() {
        return this.arquivo;
    }
    
    public PrintWriter criarPrint (FileWriter file){
        PrintWriter print = new PrintWriter(file);
        return print;
    }
}
