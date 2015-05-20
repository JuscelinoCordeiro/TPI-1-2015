///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controle;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import model.Escalonador;
//import model.Evento;
//import model.Processo;
//import model.TipoEvento;
//import view.Imprimir;
//
///**
// *
// * @author apolo
// */
//public class Principal {
//
////    public static void main(String[] args) {
//        System.out.println("TESTE DE EXECUÇÃO");
//        //fila com os processos lidos do arquivo de entrada
//        List<Processo> filaDeProcessos = new LinkedList<>();
//        
//        //fila de eventos
//        List<Processo> filaDeEventos = new LinkedList<>();
//        
//        //fila fila do escalonador
//        List<Processo> filaDoEscalonador = new LinkedList<>();
//
//        String arquivoEntrada = "/home/apolo/Dropbox/UFF-SI/TPI-1/Escalonador de Tarefas/src/arquivos/entrada.txt";
//        String arquivoSaida = "/home/apolo/Dropbox/UFF-SI/TPI-1/Escalonador de Tarefas/src/arquivos/saida.txt";
//
//        System.out.println("\nConteudo do arquivo: \n");
//
//        try {
//            //CONFIG / ABERTURA DO ARQUIVO DE ENTRADA
//            FileReader arq1 = new FileReader(arquivoEntrada);
//            BufferedReader lerArq = new BufferedReader(arq1);
//            
//
//            //CONFIG / ABERTURA DO ARQUIVO DE SAIDA
//            FileWriter arq2 = new FileWriter(arquivoSaida);
//            PrintWriter gravarArq = new PrintWriter(arq2);
//
//            String linhaLida = lerArq.readLine(); // lê a primeira linha 
//            // a variável "linha" recebe o valor "null" quando o processo de repetição atingir o final do arquivo texto 
//
//            String informacao = ""; //string para armazenar a informação lida da linha
//            while (linhaLida != null) {
//                Processo p2 = new Processo();
//                char c = ' '; //armazena a informação lida a cada caractere da linha 
//                int i = 0; //indice para percorrer a linha caractere por caractere
//                int j = 0; //indice de atributo do processo para uso no switch
//
//                while (i <= linhaLida.length()) {
//                    if (i == 0) { //primeiro cacacter da linha
//                        c = linhaLida.charAt(i);
//                        informacao = Character.toString(c);
//                    } else {
//                        if (i < linhaLida.length()) {
//                            c = linhaLida.charAt(i);
//                        }
//                        if (c == ' ' || i == linhaLida.length()) {
//                            ++j;
//                            switch (j) {
//                                case 1:
//                                    p2.setId(Integer.parseInt(informacao));
//                                    break;
//                                case 2:
//                                    p2.setTmpChegada(Integer.parseInt(informacao));
//                                    break;
//                                case 3:
//                                    p2.setDuracao(Integer.parseInt(informacao));
//                                    break;
//                                case 4:
//                                    p2.setPrioridade(Integer.parseInt(informacao));
//                                    break;
//                                default:
////                                    throw new AssertionError();
//                                    System.out.println("Deu erro no switch");
//                            }
//                            informacao = "";
//                        } else {
//                            informacao += Character.toString(c);
//                        }
//                    }
//                    i++;
//                }
//                filaDeProcessos.add(p2);
//                linhaLida = lerArq.readLine();
////                Evento e1 = new Evento(TipoEvento.chegada.getTipo(), p2, 0, TipoEvento.chegada.getPrioridade());
////                System.out.println("tipo de evento" + e1.getTipo());
////                System.out.println("tempo de evento" + e1.getTempo());
////                System.out.println("id do processo" + e1.getProcesso().getId() + "\n");
//            }
//
//            Escalonador.escalonarFilaPorPrioridade(2, filaDeProcessos);
//           // teste de saida
//            System.out.println("tamanho da fila = " + filaDeProcessos.size());
//            for (int i = 0; i < filaDeProcessos.size(); i++) {
////                Imprimir.processo(filaDeProcessos.get(i));
//
//                gravarArq.println("Dados do processo: " + (i + 1));
//                gravarArq.printf("ID TC TP P\n");
//                gravarArq.print(filaDeProcessos.get(i).getId());
//                gravarArq.print(" " + filaDeProcessos.get(i).getTmpChegada());
//                gravarArq.print(" " + filaDeProcessos.get(i).getDuracao());
//                gravarArq.print(" " + filaDeProcessos.get(i).getPrioridade());
//                gravarArq.println("\n ================================\n");
//            }
//
//            arq2.close();
//            arq1.close();
//            
//            
////            Processo p3 = filaDeProcessos.remove(0);
////            
////            filaDeProcessos.remove(0);
//////            Imprimir.processo(p3);
////            Imprimir.fila(filaDeProcessos);
//for (Iterator<Processo> it = filaDeProcessos.iterator(); it.hasNext();) {
//                Processo p = it.next();
//                System.out.println(p.getId());
//            }
//            System.out.println("tamanho da fila" + filaDeProcessos.size());
//            
//        } catch (IOException e) {
//            System.err.printf("Erro na abertura do arquivo: %s.\n",
//                    e.getMessage());
//        }
//        System.out.println("");
//    }
//}
