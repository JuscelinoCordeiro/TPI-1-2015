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
import java.util.Scanner;

/**
 *
 * @author apolo
 */
public class Principal {

    public static void main(String[] args) {
        System.out.println("TESTE DE EXECUÇÃO");
        Scanner ler = new Scanner(System.in);

//        System.out.println("Informe o nome do arquivo: \n");
//        String nome = ler.nextLine();
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
//            int cont = linhaLida.length();

//            System.out.println(cont);
            int i = 0;
            while (i < linhaLida.length()) {
                System.out.println("i = " + i);
                if (i == 0) { //primeiro cacacter da linha
                    c = linhaLida.charAt(i);
                    informacao += Character.toString(c);
                    System.out.println("informação = " + informacao);
                } else {
                    c = linhaLida.charAt(i);
                    if (c != ' ') {
                        c = linhaLida.charAt(i);
                        informacao += Character.toString(c);
                        System.out.println("informação = " + informacao);
                    } else {
                        System.out.println("Encontrou espaço.");
                        System.out.println("informação = " + informacao);
                        informacao = "vazio";
                    }
                }
                i++;
            }

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
