/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import model.ArquivoEntrada;
import model.ArquivoSaida;
import model.Escalonador;
import model.Evento;
import model.Processo;
import model.TipoEvento;
import view.Imprimir;

/**
 *
 * @author apolo
 */
public class Principal_2 {

    public static void main(String[] args) throws IOException {
        System.out.println("TESTE DE EXECUÇÃO");
        //fila com os processos lidos do arquivo de entrada
        List<Processo> filaDeProcessos = new LinkedList<>();

        //fila de eventos
        List<Processo> filaDeEventos = new LinkedList<>();

        //fila fila do escalonador
        List<Processo> filaDoEscalonador = new LinkedList<>();

        //caminho dos arquivos
        String caminhoArquivoEntrada = "/home/jfilho/Dropbox/UFF-SI/TPI-1/Escalonador de Tarefas/src/arquivos/entrada.txt";
        String caminhoArquivoSaida = "/home/jfilho/Dropbox/UFF-SI/TPI-1/Escalonador de Tarefas/src/arquivos/saida.txt";

        //inicializando os arquivos
        ArquivoEntrada arquivoEntrada = new ArquivoEntrada();
        ArquivoSaida arquivoSaida = new ArquivoSaida();

        //criando os buffers de entrada e saida de dados
        BufferedReader lerArq = null;
        BufferedWriter gravarArq = null;

        //preparando arquivo de entrada
        if (arquivoEntrada.abrir(caminhoArquivoEntrada)) {
            lerArq = arquivoEntrada.criarBuffer(arquivoEntrada.getArquivo());
        }

        //preparando arquivo de saida
        if (arquivoSaida.abrir(caminhoArquivoSaida)) {
            gravarArq = arquivoSaida.criarBuffer(arquivoSaida.getArquivo());
        }

        String linhaLida = lerArq.readLine(); // lê a primeira linha 
        // a variável "linha" recebe o valor "null" quando o processo de repetição atingir o final do arquivo texto 

        String informacao = ""; //string para armazenar a informação lida da linha
        while (linhaLida != null) {
            Processo p2 = new Processo();
            char c = ' '; //armazena a informação lida a cada caractere da linha 
            int i = 0; //indice para percorrer a linha caractere por caractere
            int j = 0; //indice de atributo do processo para uso no switch

            while (i <= linhaLida.length()) {
                if (i == 0) { //primeiro cacacter da linha
                    c = linhaLida.charAt(i);
                    informacao = Character.toString(c);
                } else {
                    if (i < linhaLida.length()) {
                        c = linhaLida.charAt(i);
                    }
                    if (c == ' ' || i == linhaLida.length()) {
                        ++j;
                        switch (j) {
                            case 1:
                                p2.setId(Integer.parseInt(informacao));
                                break;
                            case 2:
                                p2.setTmpChegada(Integer.parseInt(informacao));
                                break;
                            case 3:
                                p2.setDuracao(Integer.parseInt(informacao));
                                break;
                            case 4:
                                p2.setPrioridade(Integer.parseInt(informacao));
                                break;
                            default:
//                                    throw new AssertionError();
                                System.out.println("Deu erro no switch");
                        }
                        informacao = "";
                    } else {
                        informacao += Character.toString(c);
                    }
                }
                i++;
            }
            filaDeProcessos.add(p2);
            linhaLida = lerArq.readLine();
//                Evento e1 = new Evento(TipoEvento.chegada.getTipo(), p2, 0, TipoEvento.chegada.getPrioridade());
//                System.out.println("tipo de evento" + e1.getTipo());
//                System.out.println("tempo de evento" + e1.getTempo());
//                System.out.println("id do processo" + e1.getProcesso().getId() + "\n");
        }

//            Escalonador.escalonarFila(2, filaDeProcessos);
        // teste de saida
        System.out.println("tamanho da fila = " + filaDeProcessos.size());
        for (int i = 0; i < filaDeProcessos.size(); i++) {
            Imprimir.processo(filaDeProcessos.get(i));

        }

        arquivoEntrada.fechar(arquivoEntrada.getArquivo());
        arquivoSaida.fechar(arquivoSaida.getArquivo());

//            Processo p3 = filaDeProcessos.remove(0);
//            
//            filaDeProcessos.remove(0);
////            Imprimir.processo(p3);
//            Imprimir.fila(filaDeProcessos);
    }
}
