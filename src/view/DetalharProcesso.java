/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.Processo;

/**
 *
 * @author apolo
 */
public class DetalharProcesso {
    public static void detalhes(Processo p){
        System.out.println("Dados do processo: \n");
        System.out.println("ID: " + p.getId());
        System.out.println("ID: " + p.getTmpChegada());
        System.out.println("ID: " + p.getDuracao());
        System.out.println("ID: " + p.getPrioridade());        
    }
    
}
