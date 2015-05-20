package controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author juscelino
 */
public class Teste {

    public static void main(String[] args) throws IOException {
        System.out.println("ARQUIVO DE TESTE");

        //variavel para controlar o tempo
        int contador = 0;
        int cont;
        boolean estaVazia = false;

        //fila com os processos lidos do arquivo de entrada
        List<Processo> filaDeProcessos = new LinkedList<>();

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
        PrintWriter gravarArq = null;

        //preparando arquivo de entrada
        if (arquivoEntrada.abrir(caminhoArquivoEntrada)) {
            lerArq = arquivoEntrada.criarBuffer(arquivoEntrada.getArquivo());
        } else {
            System.out.println("Erro no arquivo de entrada.");
        }

        //preparando arquivo de saida
        if (arquivoSaida.abrir(caminhoArquivoSaida)) {
            gravarArq = arquivoSaida.criarPrint(arquivoSaida.getArquivo());
        } else {
            System.out.println("Erro no arquivo de saida.");
        }

        String linhaLida = lerArq.readLine(); // lê a primeira linha 
        // a variável "linha" recebe o valor "null" quando o processo de repetição atingir o final do arquivo texto 

        String informacao = ""; //string para armazenar a informação lida da linha

        //carrega fila de processos
        //loop principal para leitura do arquivo de entrada
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
        }

        // =====================================================================
        //  INICIO DO ESCALONAMENTO
        // =====================================================================
        BuscaEvento buscaEvento = new BuscaEvento();

        while (!estaVazia) {
            for (Processo p : filaDeProcessos) {
                if (p.getTmpChegada() == contador) {
                    buscaEvento.getEscalonador().getFilaDoEscalonador().add(p);
                }
            }
            
            System.out.println("contador = " + contador);
            System.out.println("tamanho da fila de processos = " + filaDeProcessos.size());
            System.out.println("tamanho da fila do escalonador = " + buscaEvento.getEscalonador().getFilaDoEscalonador().size());
            contador++;
            
            if (filaDeProcessos.isEmpty() || contador == 36) {
                estaVazia = true;
            }
        }

        // teste de saida
//        System.out.println("tamanho da fila = " + filaDeProcessos.size());
//        for (int i = 0; i < filaDeProcessos.size(); i++) {
//            Imprimir.processo(filaDeProcessos.get(i));
//        }
        //gravar no arquivo
//        for (int i = 0; i < filaDeProcessos.size(); i++) {
//            gravarArq.println("Dados do processo: " + (i + 1));
//            gravarArq.printf("ID TC TP P\n");
//            gravarArq.print(filaDeProcessos.get(i).getId());
//            gravarArq.print(" " + filaDeProcessos.get(i).getTmpChegada());
//            gravarArq.print(" " + filaDeProcessos.get(i).getDuracao());
//            gravarArq.print(" " + filaDeProcessos.get(i).getPrioridade());
//            gravarArq.println("\n ================================\n");
//        }
        arquivoEntrada.fechar(arquivoEntrada.getArquivo());
        if (!arquivoEntrada.verificarArquivoAberto()) {
            System.out.println("Arquivo de entrada fechado com sucesso.");
        }

        arquivoSaida.fechar(arquivoSaida.getArquivo());
        if (!arquivoSaida.verificarArquivoAberto()) {
            System.out.println("Arquivo de saida fechado com sucesso.");
        }

    }
}
