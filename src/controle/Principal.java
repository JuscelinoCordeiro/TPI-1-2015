/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author apolo
 */
public class Principal {

    public static void main(String[] args) {
        System.out.println("TESTE DE EXECUÇÃO");
//        Scanner ler = new Scanner(System.in);
        
//        System.out.println("Informe o nome do arquivo: \n");
//        String nome = ler.nextLine();
        
        String arquivoEntrada = "/home/apolo/Dropbox/UFF-SI/TPI-1/Escalonador de Tarefas/src/entrada.txt";
        String arquivoSaida = "/home/apolo/Dropbox/UFF-SI/TPI-1/Escalonador de Tarefas/src/entrada.txt";
        
        System.out.println("\nConteudo do arquivo: \n");
        //LENDO DO ARQUIVO DE ENTRADA
        try {
            FileReader arq1 = new FileReader(arquivoEntrada);
            BufferedReader lerArq = new BufferedReader(arq1);

            String linha = lerArq.readLine(); // lê a primeira linha 
            // a variável "linha" recebe o valor "null" quando o processo 
            // de repetição atingir o final do arquivo texto 
            while (linha != null) {
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            arq1.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println("");
    }
}
