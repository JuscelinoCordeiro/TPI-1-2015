/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import model.Processo;
import sun.misc.Queue;
import view.DetalharProcesso;

/**
 *
 * @author apolo
 */
public class Principal {

    public static void main(String[] args) {
        System.out.println("TESTE DE EXECUÇÃO");
 
        List <Processo> filaDeProcessos = new LinkedList<Processo>();
        Processo p1 = new Processo();

        String arquivoEntrada = "/home/apolo/Dropbox/UFF-SI/TPI-1/Escalonador de Tarefas/src/arquivos/entrada.txt";
        String arquivoSaida = "/home/apolo/Dropbox/UFF-SI/TPI-1/Escalonador de Tarefas/src/arquivos/saida.txt";

        System.out.println("\nConteudo do arquivo: \n");

        try {
            //CONFIG PARA ARQUIVO DE ENTRADA
            FileReader arq1 = new FileReader(arquivoEntrada);
            BufferedReader lerArq = new BufferedReader(arq1);

            //CONFIG PARA ARQUIVO DE SAIDA
            FileWriter arq2 = new FileWriter(arquivoSaida);
            PrintWriter gravarArq = new PrintWriter(arq2);

            String linhaLida = lerArq.readLine(); // lê a primeira linha 
            // a variável "linha" recebe o valor "null" quando o processo 
            // de repetição atingir o final do arquivo texto 

//            gravarArq.printf("ID TC TP P\n");
            String informacao = ""; //string para armazenar a informação lida da linha
            char c = ' ';
            int i = 0; //indice na linha
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
                        System.out.println("\ni =" + i);
                        ++j;
                        System.out.println("j = " + j);
                        System.out.println("informação " + informacao);
                        switch (j) {
                            case 1:
                                p1.setId(Integer.parseInt(informacao));
                                break;
                            case 2:
                                p1.setTmpChegada(Integer.parseInt(informacao));
                                break;
                            case 3:
                                p1.setDuracao(Integer.parseInt(informacao));
                                break;
                            case 4:
                                p1.setPrioridade(Integer.parseInt(informacao));
                                break;
                            default:
                                throw new AssertionError();
                        }
                        informacao = "";
                        
                    } else {
                        informacao += Character.toString(c);                   
                    }
                }
                i++;
            }
            filaDeProcessos.add(p1);
            System.out.println("tamanho da fila: " + filaDeProcessos.size());
            DetalharProcesso.detalhes(filaDeProcessos.get(0));
            /*
             for (int i = 0; i < linhaLida.length(); i++) {
             c = linhaLida.charAt(i);

             if (c == ' ') {
             System.out.println("É um espaço");
             } else {
             informacao += Character.toString(c);
             System.out.println(c);
             }
             }
             */
//            while (linha != null) {                                
//                gravarArq.println(linha);
//                
//                System.out.printf("%s\n", linha);
//                linha = lerArq.readLine(); // lê da segunda até a última linha
//            }
            arq2.close();
            arq1.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println("");
    }
}
