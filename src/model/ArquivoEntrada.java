/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author juscelino
 */
public class ArquivoEntrada {

    private FileReader arquivo;
    private boolean arquivoAberto;

    public ArquivoEntrada() {
        this.arquivoAberto = false;
    }

    public boolean abrir(String nomeArquivo) {
        try {
            this.arquivo = new FileReader(nomeArquivo);
            arquivoAberto = true;
            return arquivoAberto;
        } catch (IOException e) {
            return arquivoAberto;
        }
    }

    public boolean fechar(FileReader arq) {
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

    public FileReader getArquivo() {
        return this.arquivo;
    }
    
    public BufferedReader criarBuffer(FileReader file){
        BufferedReader buffer = new BufferedReader(file);
        return buffer;
    }
}
